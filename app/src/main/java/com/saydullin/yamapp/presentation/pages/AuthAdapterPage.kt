package com.saydullin.yamapp.presentation.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.saydullin.yamapp.domain.model.User
import com.saydullin.yamapp.presentation.viewmodel.UserViewModel
import kotlinx.coroutines.Dispatchers

@Composable
fun AuthAdapterPage(
    navController: NavController = rememberNavController(),
    userViewModel: UserViewModel = hiltViewModel()
) {

    LaunchedEffect(Dispatchers.IO) {
        userViewModel.getUser()
    }

    val userInfo = userViewModel.user.value

    if (userInfo?.isRegistered == true) {
        MainPage(
            navController = navController
        )
    }
    if (userInfo?.isRegistered == false) {
        AuthPage(
            navController = navController
        )
    }

}


