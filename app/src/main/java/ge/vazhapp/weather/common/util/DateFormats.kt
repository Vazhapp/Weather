package ge.vazhapp.weather.common.util

import java.text.SimpleDateFormat
import java.util.Date

object DateFormats {
    val gaga  = "1693325098"
    val daySdf = SimpleDateFormat("dd")
    val monthSdf = SimpleDateFormat("MMM")
    val netDate = Date(gaga.toLong() * 1000)
    val day =  daySdf.format(netDate)
    val month =  monthSdf.format(netDate)

}