package com.saydullin.yamapp.domain.model

import com.saydullin.yamapp.domain.utils.RestaurantMenuCategory

data class RestaurantMenuItem(
    val id: Int,
    val title: String,
    val description: String,
    val category: RestaurantMenuCategory,
    val image: String,
)


