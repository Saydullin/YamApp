package com.saydullin.yamapp.presentation.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.saydullin.yamapp.presentation.navigation.Screen
import com.saydullin.yamapp.presentation.viewmodel.RestaurantViewModel
import kotlinx.coroutines.Dispatchers

@Composable
fun MenuList(
    navController: NavController = rememberNavController(),
    restaurantsViewModel: RestaurantViewModel = hiltViewModel(),
) {

    LaunchedEffect(Dispatchers.IO) {
        restaurantsViewModel.getRestaurants()
    }

    val restaurantsList = restaurantsViewModel.restaurants.value ?: listOf()

    LazyColumn {
        items(restaurantsList) { restaurantItem ->
            RestaurantView(
                restaurantItem
            ) {
                navController.navigate(Screen.RestaurantMenuPage.route + "/${restaurantItem.id}")
            }
            Divider(
                color = Color.Gray,
                modifier = Modifier
                    .fillMaxWidth()
                    .alpha(.2f)
            )
        }
    }

}


