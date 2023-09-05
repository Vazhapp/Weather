package ge.vazhapp.weather.data.remote.repositories

import ge.vazhapp.weather.data.remote.core.NetworkResult
import ge.vazhapp.weather.data.remote.core.handleApi
import ge.vazhapp.weather.data.remote.model.forecast.Forecast
import ge.vazhapp.weather.data.remote.network.services.WeatherForecastService
import javax.inject.Inject

class WeatherForecastRepository @Inject constructor(
    private val weatherForecastService: WeatherForecastService
) {
    suspend fun getThreeDaysForecast(
        city: String,
    ): NetworkResult<Forecast> = handleApi {
        weatherForecastService.getThreeDaysForecast(
            city = city
        )
    }
}