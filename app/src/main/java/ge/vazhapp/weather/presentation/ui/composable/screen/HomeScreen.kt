package ge.vazhapp.weather.presentation.ui.composable.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import ge.vazhapp.weather.presentation.ui.composable.components.HomeScreenTopBar
import ge.vazhapp.weather.presentation.ui.composable.components.bottomSheets.CityBottomSheet
import ge.vazhapp.weather.presentation.ui.theme.LightBlue
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel
) {
    HomeScreen(homeViewModel = homeViewModel, gaga = "Gaga")
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    homeViewModel: HomeViewModel,
    gaga: String,
) {
    val modalBottomSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden, skipHalfExpanded = true
    )
    val scope = rememberCoroutineScope()

    val configuration = LocalConfiguration.current
    val screen60Percent = configuration.screenHeightDp * 0.6
    val screen30Percent = configuration.screenHeightDp * 0.3

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = LightBlue),

        ) {
        HomeScreenTopBar(
            onLocationChangeClick = {
                scope.launch {
                    modalBottomSheetState.show()
                }
            },
            onSettingsClick = {
                // TODO impl settings click
            }
        )
    }

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
                    viewModel = homeViewModel
                )
            }
        },
        sheetShape = RoundedCornerShape(14.dp, 14.dp),
        content = {},
    )
}