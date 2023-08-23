package ge.vazhapp.weather.presentation.ui.composable.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

@Composable
fun FullScreenDialog(
    onDismissRequest: () -> Unit = {},
    content: @Composable () -> Unit
) {
    Dialog(
        onDismissRequest = onDismissRequest,
        properties = DialogProperties(
            usePlatformDefaultWidth = false,
        ),
        content = content
    )
}

@Preview
@Composable
fun Loading(
    modifier: Modifier = Modifier
) {
    FullScreenDialog {
        CircularProgressIndicator(
            modifier = Modifier
                .size(140.dp)
                .padding(16.dp),
            color = Color.White
        )
    }
}