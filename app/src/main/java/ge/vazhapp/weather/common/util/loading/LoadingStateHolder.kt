package ge.vazhapp.weather.common.util.loading

import kotlinx.coroutines.flow.StateFlow

interface LoadingStateHolder {
    val isLoading: StateFlow<Boolean>

    fun showLoading()
    fun hideLoading()
}