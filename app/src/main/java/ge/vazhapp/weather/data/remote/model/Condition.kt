package ge.vazhapp.weather.data.remote.model


import com.squareup.moshi.Json

data class Condition(
    @Json(name = "code")
    val code: Int?,
    @Json(name = "icon")
    val icon: String?,
    @Json(name = "text")
    val text: String?
)