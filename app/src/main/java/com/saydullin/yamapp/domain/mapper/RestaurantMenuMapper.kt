package com.saydullin.yamapp.domain.mapper

import com.saydullin.yamapp.data.model.RestaurantMenuItemData
import com.saydullin.yamapp.domain.model.RestaurantMenuItem
import javax.inject.Inject

class RestaurantMenuMapper @Inject constructor()
    :Mapper<RestaurantMenuItem, RestaurantMenuItemData>() {

    override fun map(from: RestaurantMenuItem): RestaurantMenuItemData {
        return RestaurantMenuItemData(
            id = from.id,
            title = from.title,
            description = from.description,
            category = from.category,
            image = from.image,
        )
    }

}


