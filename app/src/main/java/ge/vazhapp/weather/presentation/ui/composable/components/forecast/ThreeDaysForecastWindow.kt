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
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import ge.vazhapp.weather.common.startUrlWithHttps
import ge.vazhapp.weather.data.remote.model.forecast.Forecastday

@Composable
fun ThreeDaysForecastWindow(
    modifier: Modifier = Modifier,
    threeDaysForecast: List<Forecastday>,
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
                items(threeDaysForecast) { item ->
                    EachDayCard(
                        weatherTypeImageUrl = item.day?.condition?.icon?.startUrlWithHttps().orEmpty(),
                        epoch = item.dateEpoch?.toLong() ?: 0,
                        temperatureCelsius = item.day?.maxtempC.toString()
                    )
                }
            }
        }
    }
}