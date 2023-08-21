package ge.vazhapp.weather.presentation.ui.composable.screen

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
   // private val getCurrentWeatherUseCase: GetCurrentWeatherUseCase
): ViewModel() {
    private val sections = listOf(
        "Tbilisi",
        "Batumi",
        "Gori",
    )

    private val _uiState = MutableStateFlow(sections)
    val uiState = _uiState.asStateFlow()

    fun swapSections(from: Int, to: Int) {
        val fromItem = _uiState.value[from]
        val toItem = _uiState.value[to]
        val newList = _uiState.value.toMutableList()
        newList[from] = toItem
        newList[to] = fromItem

        _uiState.value = newList
    }
}