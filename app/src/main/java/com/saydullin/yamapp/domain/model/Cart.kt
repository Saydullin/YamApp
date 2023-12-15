package com.saydullin.yamapp.domain.model

import com.saydullin.yamapp.domain.utils.RestaurantMenuCategory

data class Cart(
    val id: Int = 0,
    val menuItemId: Int = 0,
    val menuItemTitle: String,
    val menuItemDescription: String,
    val menuItemCategory: RestaurantMenuCategory,
    val menuItemImage: String,
)


