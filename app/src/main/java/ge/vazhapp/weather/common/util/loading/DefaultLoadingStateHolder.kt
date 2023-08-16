package ge.vazhapp.weather.common.util.loading

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

fun defaultLoadingStateHolder(): LoadingStateHolder = DefaultLoadingStateHolder()

class DefaultLoadingStateHolder(initialState: Boolean = false) : LoadingStateHolder {

    private val _isLoading = MutableStateFlow(initialState)
    override val isLoading: StateFlow<Boolean> get() = _isLoading.asStateFlow()

    override fun showLoading() {
        _isLoading.value = true
    }

    override fun hideLoading() {
        _isLoading.value = false
    }
}