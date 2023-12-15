package com.saydullin.yamapp.domain.repository

import com.saydullin.yamapp.data.db.dao.RestaurantDao
import com.saydullin.yamapp.domain.mapper.RestaurantEntityMapper
import com.saydullin.yamapp.domain.mapper.RestaurantMapper
import com.saydullin.yamapp.domain.mapper.RestaurantMenuItemMapper
import com.saydullin.yamapp.domain.model.Restaurant
import com.saydullin.yamapp.domain.model.RestaurantMenuItem
import com.saydullin.yamapp.domain.utils.Resource

interface RestaurantRepository {

    val restaurantDao: RestaurantDao
    val restaurantEntityMapper: RestaurantEntityMapper
    val restaurantMapper: RestaurantMapper
    val restaurantMenuItemMapper: RestaurantMenuItemMapper

    suspend fun getRestaurants(): Resource<List<Restaurant>>

    suspend fun getRestaurantById(id: Int): Resource<Restaurant>

    suspend fun updateRestaurantMenu(id: Int, menu: List<RestaurantMenuItem>): Resource<Unit>

    suspend fun saveRestaurants(list: List<Restaurant>): Resource<Unit>

}


