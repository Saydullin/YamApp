package com.saydullin.yamapp.data.model

data class RestaurantData(
    val id: Int,
    val menu: List<RestaurantMenuItemData>,
    val title: String,
    val description: String,
    val image: String,
)


