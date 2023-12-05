package com.saydullin.yamapp.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.saydullin.yamapp.data.db.entities.RestaurantEntity

@Dao
interface RestaurantDao {

    @Query("SELECT * FROM RestaurantEntity")
    fun getRestaurants(): List<RestaurantEntity>

    @Insert(RestaurantEntity::class)
    fun saveRestaurants(list: List<RestaurantEntity>)

}