package com.saydullin.yamapp.data.repository

import com.saydullin.yamapp.data.db.dao.RestaurantDao
import com.saydullin.yamapp.domain.mapper.RestaurantEntityMapper
import com.saydullin.yamapp.domain.mapper.RestaurantMapper
import com.saydullin.yamapp.domain.mapper.RestaurantMenuItemMapper
import com.saydullin.yamapp.domain.model.Restaurant
import com.saydullin.yamapp.domain.model.RestaurantMenuItem
import com.saydullin.yamapp.domain.repository.RestaurantRepository
import com.saydullin.yamapp.domain.utils.Resource
import com.saydullin.yamapp.domain.utils.StatusType
import javax.inject.Inject

class RestaurantRepositoryImpl @Inject constructor(
    override val restaurantDao: RestaurantDao,
    override val restaurantEntityMapper: RestaurantEntityMapper,
    override val restaurantMapper: RestaurantMapper,
    override val restaurantMenuItemMapper: RestaurantMenuItemMapper,
) : RestaurantRepository {

    override suspend fun getRestaurants(): Resource<List<Restaurant>> {
        return try {
            val restaurants = restaurantDao.getRestaurants()
            val restaurantsMapped = restaurants.map { restaurantEntityMapper.map(it) }
            Resource.Success(restaurantsMapped)
        } catch (e: Exception) {
            Resource.Error(StatusType.DATABASE_ERROR)
        }
    }

    override suspend fun getRestaurantById(id: Int): Resource<Restaurant> {
        return try {
            val restaurant = restaurantDao.getRestaurantById(id)
            if (restaurant != null) {
                val restaurantsMapped = restaurantEntityMapper.map(restaurant)
                Resource.Success(restaurantsMapped)
            } else {
                Resource.Error(StatusType.DATABASE_ERROR)
            }
        } catch (e: Exception) {
            Resource.Error(StatusType.DATABASE_ERROR)
        }
    }

    override suspend fun updateRestaurantMenu(id: Int, menu: List<RestaurantMenuItem>): Resource<Unit> {
        return try {
            restaurantDao.updateRestaurantMenu(id, menu.map {  restaurantMenuItemMapper.map(it) })
            Resource.Success(Unit)
        } catch(e: Exception) {
            Resource.Error(StatusType.DATABASE_ERROR)
        }
    }

    override suspend fun saveRestaurants(list: List<Restaurant>): Resource<Unit> {
        return try {
            val mappedList = list.map { restaurantMapper.map(it) }
            restaurantDao.saveRestaurants(mappedList)
            Resource.Success(Unit)
        } catch(e: Exception) {
            Resource.Error(StatusType.DATABASE_ERROR)
        }
    }

}


