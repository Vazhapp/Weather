package ge.vazhapp.weather.data.remote.model


import com.squareup.moshi.Json

data class Weather(
    @Json(name = "current")
    val current: Current,
    @Json(name = "location")
    val location: Location?
)