package ge.vazhapp.weather.presentation.ui.composable.components.bottomSheets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CityBottomSheet(
    modifier: Modifier = Modifier,
) {

    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        Text(text = "Hello guys here im", fontSize = 30.sp)
        Text(text = "Hello guys here im", fontSize = 30.sp)
        Text(text = "Hello guys here im", fontSize = 30.sp)
        Text(text = "Hello guys here im", fontSize = 30.sp)
        Text(text = "Hello guys here im", fontSize = 30.sp)
        Text(text = "Hello guys here im", fontSize = 30.sp)
        Text(text = "Hello guys here im", fontSize = 30.sp)
    }
}