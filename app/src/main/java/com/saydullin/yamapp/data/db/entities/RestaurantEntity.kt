package com.saydullin.yamapp.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class RestaurantEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val menu: List<RestaurantMenuItemEntity>,
    val address: String,
    val title: String,
    val description: String,
    val image: String,
)


