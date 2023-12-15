package com.saydullin.yamapp.presentation.pages

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.saydullin.yamapp.R
import com.saydullin.yamapp.domain.model.Restaurant
import com.saydullin.yamapp.domain.model.RestaurantMenuItem
import com.saydullin.yamapp.domain.utils.RestaurantMenuCategoryTranslate
import com.saydullin.yamapp.presentation.viewmodel.RestaurantViewModel

@Composable
fun AddRestaurantMenuPage(
    navController: NavController = rememberNavController(),
    restaurantViewModel: RestaurantViewModel = hiltViewModel(),
    argumentId: String?,
    argumentType: String?,
) {

    val titleState = remember { mutableStateOf("") }
    val descriptionState = remember { mutableStateOf("") }
    val categoryState = remember { mutableStateOf("") }
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
            Text(text = stringResource(R.string.add_restaurant_image_field))
            TextField(
                value = imageState.value,
                onValueChange = { imageState.value = it }
            )
        }
        Button(
            modifier = Modifier.padding(10.dp),
            onClick = {
                Toast.makeText(context, argumentType, Toast.LENGTH_SHORT).show()
                Toast.makeText(context, RestaurantMenuCategoryTranslate.execute(argumentType ?: "DESERTS").toString(), Toast.LENGTH_SHORT).show()
                restaurantViewModel.updateRestaurantMenu(
                    id = argumentId?.toInt() ?: 0,
                    menuItem = RestaurantMenuItem(
                        title = titleState.value,
                        description = descriptionState.value,
                        category = RestaurantMenuCategoryTranslate.execute(argumentType ?: "DESERTS"),
                        image = imageState.value
                    )
                )
            }
        ) {
            Text(text = stringResource(R.string.add))
        }
    }
}