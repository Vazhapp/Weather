package ge.vazhapp.weather.presentation.ui.composable.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.AsyncImage
import coil.imageLoader
import ge.vazhapp.weather.R

@Composable
fun MainTemperatureAndForecast(
    modifier: Modifier = Modifier,
    weatherTypeImageUrl: String,
    temperatureCelsius: String,
    threeDaysForecast: @Composable() () -> Unit,
    @DrawableRes placeHolder: Int = R.drawable.ic_placeholder,
    @DrawableRes error: Int = R.drawable.ic_placeholder,
    @DrawableRes fallback: Int = R.drawable.ic_placeholder,
) {

    ConstraintLayout(modifier = modifier.fillMaxSize()) {
        val (temperature, weatherTypeIcon, weatherForecast) = createRefs()

        Box(
            modifier = modifier
                .constrainAs(temperature) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    centerVerticallyTo(parent)
                }
        ) {
            Text(
                text = temperatureCelsius,
                fontFamily = FontFamily(listOf(Font(R.font.main_font))),
                color = Color.White,
                fontSize = 110.sp
            )
        }

        Box(
            modifier = modifier
                .fillMaxWidth()
                .constrainAs(weatherTypeIcon) {
                    top.linkTo(temperature.top, margin = 24.dp)
                    start.linkTo(temperature.end)
                    end.linkTo(temperature.end)
                },
            contentAlignment = Alignment.Center,
        ) {
            AsyncImage(
                modifier = modifier
                    .size(160.dp),
                model = weatherTypeImageUrl,
                imageLoader = LocalContext.current.imageLoader,
                placeholder = painterResource(placeHolder),
                error = painterResource(error),
                fallback = painterResource(fallback),
                contentDescription = "",
            )
        }

        Box(
            modifier = modifier
                .padding(20.dp)
                .fillMaxWidth()
                .height(200.dp)
                .constrainAs(weatherForecast) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                },
        ) {
            threeDaysForecast()
        }
    }
}