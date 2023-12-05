package com.saydullin.yamapp.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class RestaurantEntity(
    @PrimaryKey val id: Int,
    val menu: List<RestaurantMenuItemEntity>,
    val title: String,
    val description: String,
    val image: String,
)


