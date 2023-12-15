package com.saydullin.yamapp.presentation.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.saydullin.yamapp.domain.model.User
import com.saydullin.yamapp.presentation.navigation.Screen
import com.saydullin.yamapp.presentation.viewmodel.CartViewModel
import com.saydullin.yamapp.presentation.viewmodel.UserViewModel
import kotlinx.coroutines.Dispatchers

@Composable
fun ProfilePage(
    navController: NavController = rememberNavController(),
    userViewModel: UserViewModel = hiltViewModel(),
    cartViewModel: CartViewModel = hiltViewModel(),
) {

    LaunchedEffect(Dispatchers.IO) {
        userViewModel.getUser()
    }

    val cart = cartViewModel.cart.value
    val user = userViewModel.user.value

    Column(
        modifier = Modifier.padding(20.dp)
    ) {
        Text(text = "Hello, ${user?.username}")
        Spacer(modifier = Modifier.height(30.dp))
        Button(
            onClick = {
                userViewModel.saveUser(
                    User(
                        username = "Saydullin",
                        age = 21,
                        isRegistered = false,
                    )
                )
                navController.navigate(Screen.AddRestaurantPage.route)
            }
        ) {
            Text("Add Restaurant")
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = {
                userViewModel.saveUser(
                    User(
                        username = "Saydullin",
                        age = 21,
                        isRegistered = false,
                    )
                )
                navController.navigate(Screen.Auth.route) {
                    popUpTo(navController.graph.startDestinationId) {
                        inclusive = true
                    }
                    launchSingleTop = true
                }
            }
        ) {
            Text("Log out")
        }
        if (cart != null) {
            LazyColumn() {
                items(cart) {
                    Text(text = it.menuItemTitle)
                }
            }
        }
    }

}


