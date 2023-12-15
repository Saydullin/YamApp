package com.saydullin.yamapp.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.saydullin.yamapp.data.db.entities.RestaurantEntity
import com.saydullin.yamapp.data.db.entities.RestaurantMenuItemEntity

@Dao
interface RestaurantDao {

    @Query("SELECT * FROM RestaurantEntity")
    fun getRestaurants(): List<RestaurantEntity>

    @Query("SELECT * FROM RestaurantEntity WHERE id=:id")
    fun getRestaurantById(id: Int): RestaurantEntity?

    @Query("UPDATE RestaurantEntity SET menu = :menu WHERE id = :id")
    fun updateRestaurantMenu(id: Int, menu: List<RestaurantMenuItemEntity>)

    @Insert(RestaurantEntity::class, onConflict = OnConflictStrategy.REPLACE)
    fun saveRestaurants(list: List<RestaurantEntity>)

}