package ge.vazhapp.weather.presentation.ui.composable.components.forecast

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp

@Composable
fun ThreeDaysForecastWindow(
    modifier: Modifier = Modifier
) {
    val stroke = Stroke(
        width = 2f,
        pathEffect = PathEffect.dashPathEffect(floatArrayOf(30f, 20f), 0f)
    )

    val visibleState = remember { MutableTransitionState(false) }
    visibleState.targetState = true

    AnimatedVisibility(
        visibleState = visibleState,
        enter = slideInVertically(
            initialOffsetY = { fullHeight -> fullHeight },
            animationSpec = tween(
                durationMillis = 400,
                easing = LinearOutSlowInEasing
            )
        ),
    ) {
        Box(
            modifier = modifier
                .height(200.dp)
                .fillMaxWidth()
                .drawBehind {
                    drawRoundRect(color = Color.White, style = stroke)
                }
                .background(Color.White.copy(alpha = 0.25f)),
            contentAlignment = Alignment.BottomCenter,
        ) {
            LazyRow(
                modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                items(3) {
                    EachDayCard(
                        weatherTypeImageUrl = "https://cdn.weatherapi.com/weather/64x64/day/116.png",
                        epoch = "1693400895",
                        temperatureCelsius = "20.3"
                    )
                }
            }
        }
    }
}