package com.saydullin.yamapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import com.saydullin.yamapp.presentation.navigation.NavController
import com.saydullin.yamapp.presentation.pages.AuthAdapterPage
import com.saydullin.yamapp.presentation.ui.theme.YamClassicTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            YamClassicTheme {
                NavController()
            }
        }

    }
}


