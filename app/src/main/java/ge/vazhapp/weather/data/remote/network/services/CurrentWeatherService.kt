package ge.vazhapp.weather.data.remote.network.services

import ge.vazhapp.weather.data.remote.core.Constants.Api.API_KEY
import ge.vazhapp.weather.data.remote.model.Weather
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CurrentWeatherService {

    @GET("current.json")
    suspend fun getCurrentWeather(
        @Query("q") city: String,
        @Query("key") apiKey: String = API_KEY,
    ): Response<Weather>
}