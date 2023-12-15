package com.saydullin.yamapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.saydullin.yamapp.data.db.converters.RestaurantMenuListConverter
import com.saydullin.yamapp.data.db.dao.CartDao
import com.saydullin.yamapp.data.db.dao.RestaurantDao
import com.saydullin.yamapp.data.db.dao.UserDao
import com.saydullin.yamapp.data.db.entities.CartEntity
import com.saydullin.yamapp.data.db.entities.RestaurantEntity
import com.saydullin.yamapp.data.db.entities.RestaurantMenuItemEntity
import com.saydullin.yamapp.data.db.entities.UserEntity

@Database(
    entities = [
        RestaurantEntity::class,
        RestaurantMenuItemEntity::class,
        UserEntity::class,
        CartEntity::class,
    ],
    version = 1,
    exportSchema = true
)
@TypeConverters(
    RestaurantMenuListConverter::class,
)
abstract class AppDatabase: RoomDatabase() {

    abstract fun restaurantDao(): RestaurantDao

    abstract fun userDao(): UserDao

    abstract fun cartDao(): CartDao

}