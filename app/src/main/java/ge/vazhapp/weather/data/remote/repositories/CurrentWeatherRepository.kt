package ge.vazhapp.weather.data.remote.repositories

import ge.vazhapp.weather.data.remote.core.NetworkResult
import ge.vazhapp.weather.data.remote.core.handleApi
import ge.vazhapp.weather.data.remote.network.services.CurrentWeatherService
import ge.vazhapp.weather.data.remote.model.Weather
import javax.inject.Inject

class CurrentWeatherRepository @Inject constructor(
    private val currentWeatherService: CurrentWeatherService
) {
    suspend fun getCurrentWeather(city: String): NetworkResult<Weather> = handleApi {
        currentWeatherService.getCurrentWeather(city)
    }
}