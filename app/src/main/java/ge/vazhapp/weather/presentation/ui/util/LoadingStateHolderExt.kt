package ge.vazhapp.weather.presentation.ui.util

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import ge.vazhapp.weather.common.util.loading.LoadingStateHolder
import ge.vazhapp.weather.presentation.ui.composable.components.Loading

@SuppressLint("ComposableNaming")
@Composable
fun LoadingStateHolder.connectToLoading() {
    val isLoading by isLoading.collectAsStateWithLifecycle()

    if (isLoading) {
        Loading()
    }
}