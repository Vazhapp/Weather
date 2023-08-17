package ge.vazhapp.weather.presentation.ui.composable.navigation

sealed class Screens(val route: String) {
    object HomeScreen : Screens(route = "home_screen")
}
