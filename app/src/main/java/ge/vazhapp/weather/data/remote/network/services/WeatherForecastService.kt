package ge.vazhapp.weather.data.remote.network.services

import ge.vazhapp.weather.data.remote.core.Constants
import ge.vazhapp.weather.data.remote.model.forecast.Forecast
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherForecastService {

    @GET("forecast.json")
    suspend fun getThreeDaysForecast(
        @Query("q") city: String,
        @Query("days") days: Int = 3, // According to our API subscription, days are limited MAX. 3
        @Query("key") apiKey: String = Constants.Api.API_KEY,
    ): Response<Forecast>
}