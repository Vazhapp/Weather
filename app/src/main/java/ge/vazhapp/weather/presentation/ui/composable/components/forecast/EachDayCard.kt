package ge.vazhapp.weather.presentation.ui.composable.components.forecast

import androidx.annotation.DrawableRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.imageLoader
import ge.vazhapp.weather.R
import ge.vazhapp.weather.common.getMonthDay
import ge.vazhapp.weather.common.getShortlyMonth

@Composable
fun EachDayCard(
    modifier: Modifier = Modifier,
    weatherTypeImageUrl: String,
    epoch: String,
    temperatureCelsius: String,
    @DrawableRes placeHolder: Int = R.drawable.ic_placeholder,
    @DrawableRes error: Int = R.drawable.ic_placeholder,
    @DrawableRes fallback: Int = R.drawable.ic_placeholder,
) {

    val visibleState = remember { MutableTransitionState(false) }
    visibleState.targetState = true

    // Wanna move this animation in one base place
    // where It will be reusable.
    AnimatedVisibility(
        visibleState = visibleState,
        enter = slideInVertically(
            initialOffsetY = { fullHeight -> fullHeight },
            animationSpec = tween(
                durationMillis = 800,
                easing = LinearOutSlowInEasing
            )
        ),
    ) {
        Card(
            modifier = modifier
                .fillMaxWidth()
                .fillMaxHeight(0.8f)
                .padding(12.dp),
            shape = RoundedCornerShape(4.dp),
            elevation = 4.dp
        ) {
            Column(
                modifier = modifier
                    .wrapContentWidth()
                    .padding(6.dp),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = modifier
                        .wrapContentWidth(),
                    text =  "${epoch.getMonthDay()} ${epoch.getShortlyMonth()}",
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center
                )

                AsyncImage(
                    modifier = modifier
                        .size(50.dp),
                    model = weatherTypeImageUrl,
                    imageLoader = LocalContext.current.imageLoader,
                    placeholder = painterResource(placeHolder),
                    error = painterResource(error),
                    fallback = painterResource(fallback),
                    contentDescription = "",
                )

                Text(
                    modifier = modifier
                        .wrapContentWidth(),
                    text = temperatureCelsius,
                    fontSize = 20.sp,
                )
            }
        }
    }
}

