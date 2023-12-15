package com.saydullin.yamapp.domain.model

data class Restaurant(
    val id: Int = 0,
    var menu: List<RestaurantMenuItem>,
    val address: String,
    val title: String,
    val description: String,
    val image: String,
)


