package ge.vazhapp.weather.common

import android.util.Log.e
import ge.vazhapp.weather.common.Constants.EMPTY_STRING
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

const val MONTH_DAY_PATTERN = "dd"
const val MONTH_SHORTLY_PATTERN = "MMM"

private val monthDayPatternSDF = SimpleDateFormat(MONTH_DAY_PATTERN, Locale.ENGLISH)
private val monthShortlyPatternSDF = SimpleDateFormat(MONTH_SHORTLY_PATTERN, Locale.ENGLISH)

fun String.getMonthDay(): String =
    try {
        val netDate = Date(this.toLong() * 1000)
        monthDayPatternSDF.format(netDate)
    } catch (e: Exception) {
        e("MyError", "${e.message}")
        EMPTY_STRING
    }

fun String.getShortlyMonth(): String =
    try {
        val netDate = Date(this.toLong() * 1000)
        monthShortlyPatternSDF.format(netDate)
    } catch (e: Exception) {
        e("MyError", "${e.message}")
        EMPTY_STRING
    }
