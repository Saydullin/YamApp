package com.saydullin.yamapp.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.saydullin.yamapp.data.db.entities.UserEntity

@Dao
interface UserDao {

    @Query("SELECT * FROM UserEntity")
    fun getUser(): UserEntity?

    @Insert(UserEntity::class, onConflict = OnConflictStrategy.REPLACE)
    fun saveUser(user: UserEntity)

}


