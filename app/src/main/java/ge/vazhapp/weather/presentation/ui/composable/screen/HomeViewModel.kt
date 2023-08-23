package ge.vazhapp.weather.presentation.ui.composable.screen

import android.util.Log.d
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ge.vazhapp.weather.common.Constants.DEFAULT_CITY_TBILISI
import ge.vazhapp.weather.common.Constants.FIRST_ELEMENT_INDEX
import ge.vazhapp.weather.common.startUrlWithHttps
import ge.vazhapp.weather.common.util.loading.LoadingStateHolder
import ge.vazhapp.weather.common.util.loading.defaultLoadingStateHolder
import ge.vazhapp.weather.data.remote.core.NetworkResult
import ge.vazhapp.weather.domain.useCases.GetCurrentWeatherUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class HomeScreenUiState(
    val lastFetchedCity: String = "",
    val cities: List<String> = emptyList(),
    val temperatureCelsius: String = "0.0",
    val weatherTypeImageUrl: String = ""
)

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getCurrentWeatherUseCase: GetCurrentWeatherUseCase
) : ViewModel(),
    LoadingStateHolder by defaultLoadingStateHolder() {
    private val sections = listOf(
        "Tbilisi",
        "Batumi",
        "Gori",
    )

    private val _uiState = MutableStateFlow(HomeScreenUiState(cities = sections))
    val uiState = _uiState.asStateFlow()

    init {
        getDefaultCityWeather()
    }

    private fun getDefaultCityWeather() {
        viewModelScope.launch {
            showLoading()
            when (val result = getCurrentWeatherUseCase(DEFAULT_CITY_TBILISI)) {
                is NetworkResult.Error -> {
                    hideLoading()
                    d(
                        "MyError",
                        "${result.message}"
                    ) // Next time here will be some error dialog
                }

                is NetworkResult.Exception -> {
                    d("MyException", "${result.e}")
                    hideLoading()
                }

                is NetworkResult.Success -> {
                    with(result.data) {
                        _uiState.update {
                            it.copy(
                                lastFetchedCity = location?.name.orEmpty(),
                                temperatureCelsius = current.tempC.toString(),
                                weatherTypeImageUrl = current.condition?.icon?.startUrlWithHttps()
                                    ?: ""
                            )
                        }
                    }
                    hideLoading()
                }
            }
        }
    }

    fun swapSections(from: Int, to: Int) {
        val fromItem = _uiState.value.cities[from]
        val toItem = _uiState.value.cities[to]
        val newList = _uiState.value.cities.toMutableList()
        newList[from] = toItem
        newList[to] = fromItem

        _uiState.update {
            it.copy(
                cities = newList
            )
        }

        if (fromItem == newList[FIRST_ELEMENT_INDEX] || newList[FIRST_ELEMENT_INDEX] == toItem) {
            showLoading()
            viewModelScope.launch {
                when (val result = getCurrentWeatherUseCase(newList[FIRST_ELEMENT_INDEX])) {
                    is NetworkResult.Error -> {
                        hideLoading()
                        d(
                            "MyError",
                            "${result.message}"
                        ) // Next time here will be some error dialog
                    }

                    is NetworkResult.Exception -> {
                        d("MyException", "${result.e}")
                        hideLoading()
                    }

                    is NetworkResult.Success -> {
                        hideLoading()
                        _uiState.update {
                            with(result.data) {
                                it.copy(
                                    lastFetchedCity = location?.name.orEmpty(),
                                    temperatureCelsius = current.tempC.toString()
                                )
                            }

                        }
                    }
                }
            }
        }
    }
}