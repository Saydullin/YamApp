package com.saydullin.yamapp.presentation.ui.colors

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme

val LightThemeColors = lightColorScheme(
    primary = LightColors.Red,
    secondary = LightColors.LightGray,
    background = LightColors.White,
    onSurface = LightColors.DarkGray,
    onPrimary = LightColors.White,
    onSecondary = LightColors.Black,
)

val DarkThemeColors = darkColorScheme(
    primary = DarkColors.Red,
    secondary = DarkColors.DarkGray,
    background = DarkColors.Black,
    onSurface = DarkColors.LightGray,
    onPrimary = DarkColors.White,
    onSecondary = DarkColors.White,
)