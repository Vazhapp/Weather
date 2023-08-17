package ge.vazhapp.weather.presentation.ui.composable.screen

import android.util.Log.d
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import ge.vazhapp.weather.presentation.ui.composable.components.HomeScreenTopBar
import ge.vazhapp.weather.presentation.ui.theme.LightBlue

@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel
) {
    HomeScreen()
}

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = LightBlue),

        ) {
        HomeScreenTopBar(onLocationChangeClick = {
            d("MyClick", "Clicked on LocationChange")
        }, onSettingsClick = {})
    }

}