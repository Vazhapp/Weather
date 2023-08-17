package ge.vazhapp.weather.presentation.ui.composable.screen

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ge.vazhapp.weather.domain.useCases.GetCurrentWeatherUseCase
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
   // private val getCurrentWeatherUseCase: GetCurrentWeatherUseCase
): ViewModel() {

}