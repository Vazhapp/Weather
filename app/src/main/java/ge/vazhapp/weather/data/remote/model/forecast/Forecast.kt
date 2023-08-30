package ge.vazhapp.weather.data.remote.model.forecast


import com.squareup.moshi.Json
import ge.vazhapp.weather.data.remote.model.Current
import ge.vazhapp.weather.data.remote.model.Location

data class Forecast(
    @Json(name = "current")
    val current: Current?,
    @Json(name = "forecast")
    val forecast: DaysForecast?,
    @Json(name = "location")
    val location: Location?
)