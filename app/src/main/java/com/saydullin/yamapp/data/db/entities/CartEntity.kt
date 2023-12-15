package com.saydullin.yamapp.data.db.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CartEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @Embedded(prefix = "menu_item_") val menuItem: RestaurantMenuItemEntity,
)