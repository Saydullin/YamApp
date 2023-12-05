package com.saydullin.yamapp.data.model

import com.saydullin.yamapp.domain.utils.RestaurantMenuCategory

data class RestaurantMenuItemData(
    val id: Int,
    val title: String,
    val description: String,
    val category: RestaurantMenuCategory,
    val image: String,
)


