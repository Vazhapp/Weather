package ge.vazhapp.weather.domain.useCases

import ge.vazhapp.weather.data.remote.core.NetworkResult
import ge.vazhapp.weather.data.remote.model.forecast.Forecast
import ge.vazhapp.weather.data.remote.repositories.WeatherForecastRepository
import javax.inject.Inject

class GetThreeDaysForecastUseCase @Inject constructor(
    private val weatherForecastRepository: WeatherForecastRepository
) {
    suspend operator fun invoke(city: String): NetworkResult<Forecast> =
        weatherForecastRepository.getThreeDaysForecast(city = city)
}