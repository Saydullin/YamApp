package com.saydullin.yamapp.presentation.pages

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.saydullin.yamapp.R
import com.saydullin.yamapp.domain.utils.RestaurantMenuCategory
import com.saydullin.yamapp.presentation.navigation.Screen
import com.saydullin.yamapp.presentation.viewmodel.RestaurantViewModel
import kotlinx.coroutines.Dispatchers

@Composable
fun RestaurantMenuPage(
    navController: NavController = rememberNavController(),
    restaurantViewModel: RestaurantViewModel = hiltViewModel(),
    argumentId: String?,
) {

    LaunchedEffect(Dispatchers.IO) {
        val id = argumentId?.toInt()
        if (id != null) {
            restaurantViewModel.getRestaurantById(id)
        }
    }
    val restaurant = restaurantViewModel.restaurantActive.value ?: return

    Column {
        Text(
            modifier = Modifier
                .padding(20.dp),
            text = restaurant.title,
            style = MaterialTheme.typography.titleLarge
        )
        Image(
            painter = rememberAsyncImagePainter(restaurant.image),
            contentDescription = restaurant.title,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .height(200.dp)
                .fillMaxSize()
        )
        LazyColumn(modifier = Modifier
            .padding(20.dp)
        ) {
            item {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier
                            .padding(vertical = 20.dp),
                        text = "Breakfasts",
                        style = MaterialTheme.typography.titleLarge
                    )
                    Spacer(
                        modifier = Modifier
                            .weight(1f)
                    )
                    Button(
                        modifier = Modifier.padding(horizontal = 10.dp),
                        onClick = { navController.navigate(Screen.AddRestaurantMenuPage.route + "/${argumentId}/Breakfasts") }
                    ) {
                        Text(text = stringResource(R.string.add))
                    }
                }
            }
            items(restaurant.menu.filter { it.category == RestaurantMenuCategory.BREAKFASTS }) { restaurantMenuItem ->
                Row(
                    modifier = Modifier.padding(10.dp)
                ) {
                    Column {
                        Text(text = restaurantMenuItem.title, style = MaterialTheme.typography.titleMedium)
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(text = restaurantMenuItem.description)
                    }
                    Spacer(modifier = Modifier
                        .height(10.dp)
                        .weight(1f))
                    Box(modifier = Modifier
                        .clip(RoundedCornerShape(10.dp))
                    ) {
                        Image(
                            painter = rememberAsyncImagePainter(restaurantMenuItem.image),
                            contentDescription = restaurant.title,
                            contentScale = ContentScale.FillWidth,
                            modifier = Modifier
                                .height(100.dp)
                                .width(200.dp)
                                .fillMaxSize()
                        )
                    }
                }
                Divider(
                    color = Color.Gray,
                    modifier = Modifier
                        .fillMaxWidth()
                        .alpha(.2f)
                )
            }
            item {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier
                            .padding(vertical = 20.dp),
                        text = "Salads",
                        style = MaterialTheme.typography.titleLarge
                    )
                    Spacer(
                        modifier = Modifier
                            .weight(1f)
                    )
                    Button(
                        modifier = Modifier.padding(horizontal = 10.dp),
                        onClick = { navController.navigate(Screen.AddRestaurantMenuPage.route + "/${argumentId}/Salads") }
                    ) {
                        Text(text = stringResource(R.string.add))
                    }
                }
            }
            items(restaurant.menu.filter { it.category == RestaurantMenuCategory.SALADS }) { restaurantMenuItem ->
                Row(
                    modifier = Modifier.padding(10.dp)
                ) {
                    Column {
                        Text(text = restaurantMenuItem.title, style = MaterialTheme.typography.titleMedium)
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(text = restaurantMenuItem.description)
                    }
                    Spacer(modifier = Modifier
                        .height(10.dp)
                        .weight(1f))
                    Box(modifier = Modifier
                        .clip(RoundedCornerShape(10.dp))
                    ) {
                        Image(
                            painter = rememberAsyncImagePainter(restaurantMenuItem.image),
                            contentDescription = restaurant.title,
                            contentScale = ContentScale.FillWidth,
                            modifier = Modifier
                                .height(100.dp)
                                .width(200.dp)
                                .fillMaxSize()
                        )
                    }
                }
                Divider(
                    color = Color.Gray,
                    modifier = Modifier
                        .fillMaxWidth()
                        .alpha(.2f)
                )
            }
            item {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier
                            .padding(vertical = 20.dp),
                        text = "Deserts",
                        style = MaterialTheme.typography.titleLarge
                    )
                    Spacer(
                        modifier = Modifier
                            .weight(1f)
                    )
                    Button(
                        modifier = Modifier.padding(horizontal = 10.dp),
                        onClick = { navController.navigate(Screen.AddRestaurantMenuPage.route + "/${argumentId}/Deserts") }
                    ) {
                        Text(text = stringResource(R.string.add))
                    }
                }
            }
            items(restaurant.menu.filter { it.category == RestaurantMenuCategory.DESERTS }) { restaurantMenuItem ->
                Row(
                    modifier = Modifier.padding(10.dp)
                ) {
                    Column {
                        Text(text = restaurantMenuItem.title, style = MaterialTheme.typography.titleMedium)
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(text = restaurantMenuItem.description)
                    }
                    Spacer(modifier = Modifier
                        .height(10.dp)
                        .weight(1f))
                    Box(modifier = Modifier
                        .clip(RoundedCornerShape(10.dp))
                    ) {
                        Image(
                            painter = rememberAsyncImagePainter(restaurantMenuItem.image),
                            contentDescription = restaurant.title,
                            contentScale = ContentScale.FillWidth,
                            modifier = Modifier
                                .height(100.dp)
                                .width(200.dp)
                                .fillMaxSize()
                        )
                    }
                }
                Divider(
                    color = Color.Gray,
                    modifier = Modifier
                        .fillMaxWidth()
                        .alpha(.2f)
                )
            }
            item {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier
                            .padding(vertical = 20.dp),
                        text = "Soups",
                        style = MaterialTheme.typography.titleLarge
                    )
                    Spacer(
                        modifier = Modifier
                            .weight(1f)
                    )
                    Button(
                        modifier = Modifier.padding(horizontal = 10.dp),
                        onClick = { navController.navigate(Screen.AddRestaurantMenuPage.route + "/${argumentId}/Deserts") }
                    ) {
                        Text(text = stringResource(R.string.add))
                    }
                }
            }
            items(restaurant.menu.filter { it.category == RestaurantMenuCategory.SOUPS }) { restaurantMenuItem ->
                Row(
                    modifier = Modifier.padding(10.dp)
                ) {
                    Column {
                        Text(text = restaurantMenuItem.title, style = MaterialTheme.typography.titleMedium)
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(text = restaurantMenuItem.description)
                    }
                    Spacer(modifier = Modifier
                        .height(10.dp)
                        .weight(1f))
                    Box(modifier = Modifier
                        .clip(RoundedCornerShape(10.dp))
                    ) {
                        Image(
                            painter = rememberAsyncImagePainter(restaurantMenuItem.image),
                            contentDescription = restaurant.title,
                            contentScale = ContentScale.FillWidth,
                            modifier = Modifier
                                .height(100.dp)
                                .width(200.dp)
                                .fillMaxSize()
                        )
                    }
                }
                Divider(
                    color = Color.Gray,
                    modifier = Modifier
                        .fillMaxWidth()
                        .alpha(.2f)
                )
            }
            item {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier
                            .padding(vertical = 20.dp),
                        text = "Snacks",
                        style = MaterialTheme.typography.titleLarge
                    )
                    Spacer(
                        modifier = Modifier
                            .weight(1f)
                    )
                    Button(
                        modifier = Modifier.padding(horizontal = 10.dp),
                        onClick = { navController.navigate(Screen.AddRestaurantMenuPage.route + "/${argumentId}/Deserts") }
                    ) {
                        Text(text = stringResource(R.string.add))
                    }
                }
            }
            items(restaurant.menu.filter { it.category == RestaurantMenuCategory.SNACKS }) { restaurantMenuItem ->
                Row(
                    modifier = Modifier.padding(10.dp)
                ) {
                    Column {
                        Text(text = restaurantMenuItem.title, style = MaterialTheme.typography.titleMedium)
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(text = restaurantMenuItem.description)
                    }
                    Spacer(modifier = Modifier
                        .height(10.dp)
                        .weight(1f))
                    Box(modifier = Modifier
                        .clip(RoundedCornerShape(10.dp))
                    ) {
                        Image(
                            painter = rememberAsyncImagePainter(restaurantMenuItem.image),
                            contentDescription = restaurant.title,
                            contentScale = ContentScale.FillWidth,
                            modifier = Modifier
                                .height(100.dp)
                                .width(200.dp)
                                .fillMaxSize()
                        )
                    }
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
}


