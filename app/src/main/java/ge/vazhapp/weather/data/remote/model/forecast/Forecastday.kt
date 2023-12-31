package ge.vazhapp.weather.data.remote.model.forecast


import com.squareup.moshi.Json

data class Forecastday(
    @Json(name = "astro")
    val astro: Astro?,
    @Json(name = "date")
    val date: String?,
    @Json(name = "date_epoch")
    val dateEpoch: Int?,
    @Json(name = "day")
    val day: Day?,
    @Json(name = "hour")
    val hour: List<Hour>?
)