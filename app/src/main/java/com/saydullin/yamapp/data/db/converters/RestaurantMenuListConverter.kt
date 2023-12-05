package com.saydullin.yamapp.data.db.converters

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.saydullin.yamapp.data.db.entities.RestaurantMenuItemEntity

@ProvidedTypeConverter
class RestaurantMenuListConverter {

    @TypeConverter
    fun fromRestaurantMenuToString(menu: List<RestaurantMenuItemEntity>?): String? {
        return Gson().toJson(menu)
    }

    @TypeConverter
    fun fromStringToRestaurantMenu(menu: String): List<RestaurantMenuItemEntity>? {
        val listType = object: TypeToken<List<RestaurantMenuItemEntity>>(){}.type
        return Gson().fromJson(menu, listType)
    }

}