package ge.vazhapp.weather.data.remote.model.forecast


import com.squareup.moshi.Json

data class Astro(
    @Json(name = "is_moon_up")
    val isMoonUp: Int?,
    @Json(name = "is_sun_up")
    val isSunUp: Int?,
    @Json(name = "moon_illumination")
    val moonIllumination: String?,
    @Json(name = "moon_phase")
    val moonPhase: String?,
    @Json(name = "moonrise")
    val moonrise: String?,
    @Json(name = "moonset")
    val moonset: String?,
    @Json(name = "sunrise")
    val sunrise: String?,
    @Json(name = "sunset")
    val sunset: String?
)