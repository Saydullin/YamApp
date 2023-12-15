package com.saydullin.yamapp.domain.mapper

import com.saydullin.yamapp.data.db.entities.RestaurantEntity
import com.saydullin.yamapp.domain.model.Restaurant
import javax.inject.Inject

class RestaurantMapper @Inject constructor(
    private val restaurantMenuItemMapper: RestaurantMenuItemMapper
): Mapper<Restaurant, RestaurantEntity>() {

    override fun map(from: Restaurant): RestaurantEntity {
        return RestaurantEntity(
            menu = from.menu.map { restaurantMenuItemMapper.map(it) },
            address = from.address,
            title = from.title,
            description = from.description,
            image = from.image,
        )
    }

}


