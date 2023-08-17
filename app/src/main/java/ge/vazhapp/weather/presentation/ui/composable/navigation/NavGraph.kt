package ge.vazhapp.weather.presentation.ui.composable.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ge.vazhapp.weather.presentation.ui.composable.screen.HomeScreen

@Composable
fun Navigation(
    modifier: Modifier = Modifier,
    startDestination: String = Screens.HomeScreen.route
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ) {
        composable(
            route = Screens.HomeScreen.route
        ) {
            HomeScreen(homeViewModel = hiltViewModel())
        }
    }
}