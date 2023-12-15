package com.saydullin.yamapp.presentation.navigation

import com.saydullin.yamapp.R

sealed class Screen(
    val route: String,
    val title: String,
    val icon: Int,
    val activeIcon: Int
) {
    object Home : Screen(
        route = "home",
        title = "Home",
        icon = R.drawable.home,
        activeIcon = R.drawable.home
    )
    object Profile : Screen(
        route = "profile",
        title = "Profile",
        icon = R.drawable.account_circle,
        activeIcon = R.drawable.account_circle_filled
    )
    object AddRestaurantMenuPage : Screen(
        route = "addRestaurantMenuPage",
        title = "addRestaurantMenuPage",
        icon = R.drawable.account_circle,
        activeIcon = R.drawable.account_circle_filled
    )
    object Auth : Screen(
        route = "auth",
        title = "Auth",
        icon = R.drawable.home,
        activeIcon = R.drawable.home
    )
    object AddRestaurantPage : Screen(
        route = "addRestaurantPage",
        title = "AddRestaurantPage",
        icon = R.drawable.bookmark_icon,
        activeIcon = R.drawable.bookmark_screen_active
    )
    object RestaurantMenuPage : Screen(
        route = "restaurantMenuPage",
        title = "RestaurantMenuPage",
        icon = R.drawable.bookmark_icon,
        activeIcon = R.drawable.bookmark_screen_active
    )
}