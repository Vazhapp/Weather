package ge.vazhapp.weather.presentation.ui.composable.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.AsyncImage
import coil.imageLoader
import ge.vazhapp.weather.R

@Preview
@Composable
fun MainTemperature(
    modifier: Modifier = Modifier,
    // this url will be dynamic soon
    weatherTypeImageUrl: String = "https://cdn.weatherapi.com/weather/64x64/day/113.png",
    @DrawableRes placeHolder: Int = R.drawable.ic_placeholder,
    @DrawableRes error: Int = R.drawable.ic_placeholder,
    @DrawableRes fallback: Int = R.drawable.ic_placeholder,
) {

    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        ConstraintLayout {
            val (temperature, weatherTypeIcon) = createRefs()

            Box(
                modifier = modifier
                    .constrainAs(temperature) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = "0.0",
                    fontFamily = FontFamily(listOf(Font(R.font.main_font))),
                    color = Color.White,
                    fontSize = 110.sp
                )
            }

            Box(
                modifier = modifier
                    .fillMaxWidth()
                    .constrainAs(weatherTypeIcon) {
                        top.linkTo(temperature.top, margin = 22.dp)
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
        }
    }
}