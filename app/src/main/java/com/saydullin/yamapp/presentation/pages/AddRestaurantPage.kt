package com.saydullin.yamapp.presentation.pages

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.saydullin.yamapp.R
import com.saydullin.yamapp.domain.model.Restaurant
import com.saydullin.yamapp.presentation.viewmodel.RestaurantViewModel

@Composable
fun AddRestaurantPage(
    navController: NavController = rememberNavController(),
    restaurantViewModel: RestaurantViewModel = hiltViewModel()
) {

    val titleState = remember { mutableStateOf("") }
    val descriptionState = remember { mutableStateOf("") }
    val addressState = remember { mutableStateOf("") }
    val imageState = remember { mutableStateOf("") }
    val context = LocalContext.current
    val addedText = stringResource(R.string.added)

    Column {
        Column(
            modifier = Modifier
                .padding(10.dp)
        ) {
            Text(text = stringResource(R.string.add_restaurant_title_field))
            TextField(
                value = titleState.value,
                onValueChange = { titleState.value = it }
            )
        }
        Column(
            modifier = Modifier
                .padding(10.dp)
        ) {
            Text(text = stringResource(R.string.add_restaurant_description_field))
            TextField(
                value = descriptionState.value,
                onValueChange = { descriptionState.value = it }
            )
        }
        Column(
            modifier = Modifier
                .padding(10.dp)
        ) {
            Text(text = stringResource(R.string.add_restaurant_address_field))
            TextField(
                value = addressState.value,
                onValueChange = { addressState.value = it }
            )
        }
        Column(
            modifier = Modifier
                .padding(10.dp)
        ) {
            Text(text = stringResource(R.string.add_restaurant_image_field))
            TextField(
                value = imageState.value,
                onValueChange = { imageState.value = it }
            )
        }
        Row(
            modifier = Modifier.padding(horizontal = 10.dp)
        ) {
            Button(
                onClick = {
                    navController.popBackStack()
                }
            ) {
                Text(text = stringResource(R.string.cancel))
            }
            Spacer(
                modifier = Modifier
                    .height(1.dp)
                    .weight(1f)
            )
            Button(
                onClick = {
                    Toast.makeText(context, addedText, Toast.LENGTH_SHORT).show()
                    restaurantViewModel.saveRestaurants(listOf(
                        Restaurant(
                            menu = listOf(),
                            title = titleState.value,
                            description = descriptionState.value,
                            address = addressState.value,
                            image = imageState.value
                        )
                    ))
                    restaurantViewModel.getRestaurants()
                }
            ) {
                Text(text = stringResource(R.string.add))
            }
        }
    }

}


