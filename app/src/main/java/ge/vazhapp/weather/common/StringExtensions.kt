package ge.vazhapp.weather.common

fun String.startUrlWithHttps(): String =
    "https:$this"
