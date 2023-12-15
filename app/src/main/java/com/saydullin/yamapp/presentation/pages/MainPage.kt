package com.saydullin.yamapp.presentation.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.saydullin.yamapp.domain.model.User
import com.saydullin.yamapp.presentation.component.MenuList
import com.saydullin.yamapp.presentation.navigation.Screen
import com.saydullin.yamapp.presentation.viewmodel.UserViewModel

@Composable
fun MainPage(
    navController: NavController = rememberNavController(),
    userViewModel: UserViewModel = hiltViewModel(),
) {

    Column {
        MenuList(
            navController = navController
        )
    }

}


