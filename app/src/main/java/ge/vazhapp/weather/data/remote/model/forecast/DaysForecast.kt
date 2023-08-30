package ge.vazhapp.weather.data.remote.model.forecast


import com.squareup.moshi.Json

data class DaysForecast(
    @Json(name = "forecastday")
    val forecastday: List<Forecastday>?
)