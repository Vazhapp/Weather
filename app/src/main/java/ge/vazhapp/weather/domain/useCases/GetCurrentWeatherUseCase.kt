package ge.vazhapp.weather.domain.useCases

import ge.vazhapp.weather.data.remote.core.NetworkResult
import ge.vazhapp.weather.data.remote.repositories.CurrentWeatherRepository
import ge.vazhapp.weather.data.remote.model.Weather
import javax.inject.Inject

class GetCurrentWeatherUseCase @Inject constructor(
    private val repository: CurrentWeatherRepository
) {
    suspend operator fun invoke(city: String): NetworkResult<Weather> =
        repository.getCurrentWeather(city)
}