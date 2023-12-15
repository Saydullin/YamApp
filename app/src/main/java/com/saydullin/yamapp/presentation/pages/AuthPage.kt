package com.saydullin.yamapp.presentation.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.saydullin.yamapp.R
import com.saydullin.yamapp.domain.model.User
import com.saydullin.yamapp.presentation.navigation.Screen
import com.saydullin.yamapp.presentation.viewmodel.UserViewModel

@Composable
fun AuthPage(
    navController: NavController = rememberNavController(),
    userViewModel: UserViewModel = hiltViewModel(),
) {

    val usernameState = remember { mutableStateOf("") }
    val ageState = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = stringResource(R.string.sign_in),
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(
            modifier = Modifier
                .height(20.dp)
        )
        Column(
            modifier = Modifier
                .padding(10.dp)
        ) {
            Text(text = stringResource(R.string.auth_username_field))
            TextField(
                value = usernameState.value,
                onValueChange = { usernameState.value = it }
            )
        }
        Column(
            modifier = Modifier
                .padding(10.dp)
        ) {
            Text(text = stringResource(R.string.auth_age_field))
            TextField(
                value = ageState.value,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                onValueChange = { ageState.value = it }
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = {
                userViewModel.saveUser(
                    User(
                        username = usernameState.value,
                        age = ageState.value.toInt(),
                        isRegistered = true,
                    )
                )
                navController.navigate(Screen.Home.route) {
                    popUpTo(navController.graph.startDestinationId) {
                        inclusive = true
                    }
                    launchSingleTop = true
                }
            }
        ) {
            Text("Sign in")
        }
    }

}


