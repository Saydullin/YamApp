package com.saydullin.yamapp.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.saydullin.yamapp.data.db.entities.CartEntity

@Dao
interface CartDao {

    @Query("SELECT * FROM CartEntity")
    fun getCart(): List<CartEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveCartItem(cartEntity: CartEntity)

    @Query("DELETE FROM CartEntity WHERE id=:id")
    fun removeCartItem(id: Int)

}