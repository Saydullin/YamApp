package com.saydullin.yamapp.domain.mapper

import com.saydullin.yamapp.data.db.entities.RestaurantEntity
import com.saydullin.yamapp.domain.model.Restaurant
import javax.inject.Inject

class RestaurantEntityMapper @Inject constructor(
    private val restaurantMenuEntityMapper: RestaurantMenuEntityMapper
): Mapper<RestaurantEntity, Restaurant>() {

    override fun map(from: RestaurantEntity): Restaurant {
        return Restaurant(
            id = from.id,
            menu = from.menu.map { restaurantMenuEntityMapper.map(it) },
            address = from.address,
            title = from.title,
            description = from.description,
            image = from.image,
        )
    }

}


