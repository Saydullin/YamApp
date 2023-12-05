package com.saydullin.yamapp.domain.model

data class Restaurant(
    val id: Int,
    val menu: List<RestaurantMenuItem>,
    val title: String,
    val description: String,
    val image: String,
)


