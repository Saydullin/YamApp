package com.saydullin.yamapp.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.saydullin.yamapp.domain.model.Restaurant

typealias onClickCallback = () -> Unit

@Composable
fun RestaurantView(
    restaurant: Restaurant,
    onClick: onClickCallback,
) {

    Column(
        modifier = Modifier
            .padding(20.dp)
    ) {
        Text(
            text = restaurant.title,
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(
            modifier = Modifier
                .height(10.dp)
        )
        Box(modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
        ) {
            Image(
                painter = rememberAsyncImagePainter(restaurant.image),
                contentDescription = restaurant.title,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxSize()
                    .clickable {
                        onClick()
                    }
            )
        }
        Text(
            text = restaurant.address,
            style = MaterialTheme.typography.labelMedium
        )
    }

}