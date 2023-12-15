package com.saydullin.yamapp.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class RestaurantMenuItemEntity(
    @PrimaryKey val id: Int,
    val title: String,
    val description: String,
    val category: String,
    val image: String,
)


