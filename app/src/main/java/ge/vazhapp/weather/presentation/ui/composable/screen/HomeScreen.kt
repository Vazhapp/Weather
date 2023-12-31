package ge.vazhapp.weather.presentation.ui.composable.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import ge.vazhapp.weather.data.remote.model.forecast.Forecastday
import ge.vazhapp.weather.presentation.ui.composable.components.HomeScreenTopBar
import ge.vazhapp.weather.presentation.ui.composable.components.MainTemperatureAndForecast
import ge.vazhapp.weather.presentation.ui.composable.components.forecast.ThreeDaysForecastWindow
import ge.vazhapp.weather.presentation.ui.composable.components.bottomSheets.CityBottomSheet
import ge.vazhapp.weather.presentation.ui.theme.LightBlue
import ge.vazhapp.weather.presentation.ui.util.connectToLoading
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel
) {
    homeViewModel.connectToLoading()
    val uiState by homeViewModel.uiState.collectAsStateWithLifecycle()

    HomeScreen(
        modifier = Modifier,
        homeScreenUiState = uiState,
        cities = uiState.cities,
        swapActions = homeViewModel::swapSections,
        lastFetchedCity = uiState.lastFetchedCity,
        threeDaysForecast = uiState.threeDaysForecast,
    )
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HomeScreen(
    modifier: Modifier,
    homeScreenUiState: HomeScreenUiState,
    cities: List<String>,
    swapActions: (from: Int, to: Int) -> Unit,
    lastFetchedCity: String,
    threeDaysForecast: List<Forecastday>,
) {
    val modalBottomSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden, skipHalfExpanded = true
    )
    val scope = rememberCoroutineScope()

    val configuration = LocalConfiguration.current
    val screen60Percent = configuration.screenHeightDp * 0.6
    val screen30Percent = configuration.screenHeightDp * 0.3

    // We need ModalBottomSheetLayout, because only this BottomSheet can be closed when clicking
    // outside of bottomSheet
    ModalBottomSheetLayout(
        sheetState = modalBottomSheetState,
        scrimColor = Color.Transparent,
        sheetContent = {
            Column(
                Modifier
                    .heightIn(min = screen30Percent.dp, max = screen60Percent.dp)
            ) {
                CityBottomSheet(
                    cities = cities,
                    swapSections = swapActions
                )
            }
        },
        sheetShape = RoundedCornerShape(14.dp, 14.dp),
    ) {
        Box(
            modifier = modifier
                .background(color = LightBlue),
        ) {
            HomeScreenTopBar(
                lastFetchedCity = lastFetchedCity,
                onLocationChangeClick = {
                    scope.launch {
                        modalBottomSheetState.show()
                    }
                },
                onSettingsClick = {
                    // TODO impl settings click
                }
            )

            MainTemperatureAndForecast(
                weatherTypeImageUrl = homeScreenUiState.weatherTypeImageUrl,
                temperatureCelsius = homeScreenUiState.temperatureCelsius,
                threeDaysForecast = {
                    ThreeDaysForecastWindow(
                        threeDaysForecast = threeDaysForecast
                    )
                }
            )
        }
    }
}