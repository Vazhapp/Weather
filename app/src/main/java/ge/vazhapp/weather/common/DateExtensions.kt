package ge.vazhapp.weather.common

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

const val MONTH_DAY_PATTERN = "dd"
const val MONTH_SHORTLY_PATTERN = "MMM"

private val monthDayPatternSDF = SimpleDateFormat(MONTH_DAY_PATTERN, Locale.ENGLISH)
private val monthShortlyPatternSDF = SimpleDateFormat(MONTH_SHORTLY_PATTERN, Locale.ENGLISH)

fun Long.getMonthDay(): String {
    val netDate = Date(this * 1000)
    return monthDayPatternSDF.format(netDate)
}

fun Long.getShortlyMonth(): String {
    val netDate = Date(this * 1000)
    return monthShortlyPatternSDF.format(netDate)
}

