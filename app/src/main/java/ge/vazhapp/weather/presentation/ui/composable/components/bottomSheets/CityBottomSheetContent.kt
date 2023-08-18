package ge.vazhapp.weather.presentation.ui.composable.components.bottomSheets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ge.vazhapp.weather.R
import ge.vazhapp.weather.common.Constants.FIRST_ELEMENT_INDEX

@Composable
fun CityBottomSheet(
    modifier: Modifier = Modifier,
) {

    LazyColumn(
        modifier = modifier
            .padding(16.dp)
    ) {
        itemsIndexed(
            listOf(
                "Tbilisi",
                "Batumi",
                "Gori",
            )
        ) { index, item ->
            CityCard(city = item, indexOfCity = index)
        }
    }
}

@Composable
fun CityCard(
    modifier: Modifier = Modifier,
    city: String,
    indexOfCity: Int
) {

    val isCityFavorite by remember {
        mutableStateOf(indexOfCity == FIRST_ELEMENT_INDEX)
    }

    Card(
        modifier = modifier
            .padding(10.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        elevation = 6.dp,

        ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
        ) {
            Text(
                modifier = modifier.padding(6.dp),
                text = city,
                fontSize = 22.sp,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = modifier.weight(1f))

            if (isCityFavorite) {
                Image(
                    modifier = modifier
                        .size(44.dp)
                        .padding(6.dp)
                        .align(Alignment.CenterVertically),

                    painter = painterResource(id = R.drawable.ic_star),
                    contentDescription = ""
                )
            }
        }
    }
}