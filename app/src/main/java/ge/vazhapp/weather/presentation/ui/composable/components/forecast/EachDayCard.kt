package ge.vazhapp.weather.presentation.ui.composable.components.forecast

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.imageLoader
import ge.vazhapp.weather.R

@Composable
fun EachDayCard(
    modifier: Modifier = Modifier,
    weatherTypeImageUrl: String,
    @DrawableRes placeHolder: Int = R.drawable.ic_placeholder,
    @DrawableRes error: Int = R.drawable.ic_placeholder,
    @DrawableRes fallback: Int = R.drawable.ic_placeholder,
) {

    Card(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight(0.8f)
            .padding(12.dp),
        shape = RoundedCornerShape(4.dp),
        elevation = 4.dp
    ) {
        Column(
            modifier = modifier
                .wrapContentWidth(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = modifier
                    .wrapContentWidth(),
                text = "Date",
                fontSize = 18.sp,
                textAlign = TextAlign.Center
            )

            AsyncImage(
                modifier = modifier
                    .size(50.dp),
                model = weatherTypeImageUrl,
                imageLoader = LocalContext.current.imageLoader,
                placeholder = painterResource(placeHolder),
                error = painterResource(error),
                fallback = painterResource(fallback),
                contentDescription = "",
            )

            Text(
                modifier = modifier
                    .wrapContentWidth(), text = "20.3", fontSize = 20.sp
            )
        }
    }
}

