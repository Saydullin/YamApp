package com.saydullin.yamapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.saydullin.yamapp.data.db.converters.RestaurantMenuListConverter
import com.saydullin.yamapp.data.db.dao.RestaurantDao
import com.saydullin.yamapp.data.db.entities.RestaurantEntity
import com.saydullin.yamapp.data.db.entities.RestaurantMenuItemEntity

@Database(
    entities = [
        RestaurantEntity::class,
        RestaurantMenuItemEntity::class,
    ],
    version = 1,
    exportSchema = true
)
@TypeConverters(
    RestaurantMenuListConverter::class,
)
abstract class AppDatabase: RoomDatabase() {

    abstract fun restaurantDao(): RestaurantDao

}