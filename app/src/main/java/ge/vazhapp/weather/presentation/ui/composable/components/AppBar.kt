package ge.vazhapp.weather.presentation.ui.composable.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ge.vazhapp.weather.R
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun HomeScreenTopBar(
    modifier: Modifier = Modifier,
    onLocationChangeClick: () -> Unit,
    onSettingsClick: () -> Unit,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(all = 12.dp)
    ) {
        Row {
            Column {
                Spacer(modifier = modifier.height(36.dp))

                Row(
                    modifier = modifier
                        .clickable {
                            onLocationChangeClick()
                        }
                ) {
                    Text(
                        text = "Tbilisi",
                        color = Color.White,
                        fontSize = 38.sp,
                        fontFamily = FontFamily(fonts = listOf(Font(R.font.main_font)))
                    )

                    Image(
                        modifier = modifier
                            .padding(start = 8.dp)
                            .align(Alignment.CenterVertically),
                        painter = painterResource(id = R.drawable.ic_location),
                        contentDescription = "",
                    )

                    Image(
                        modifier = modifier
                            .align(Alignment.CenterVertically)
                            .size(28.dp),
                        painter = painterResource(id = R.drawable.ic_arrow_drop_down),
                        contentDescription = ""
                    )
                }
            }
            Spacer(
                modifier = modifier
                    .height(116.dp)
                    .weight(1f)
            )

            Image(
                modifier = modifier
                    .size(32.dp)
                    .align(Alignment.CenterVertically)
                    .clickable {
                        onSettingsClick()
                    },
                painter = painterResource(id = R.drawable.ic_settings),
                contentDescription = ""
            )
        }
    }
}