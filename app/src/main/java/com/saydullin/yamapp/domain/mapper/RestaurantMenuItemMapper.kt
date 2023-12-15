package com.saydullin.yamapp.domain.mapper

import com.saydullin.yamapp.data.db.entities.RestaurantMenuItemEntity
import com.saydullin.yamapp.data.model.RestaurantMenuItemData
import com.saydullin.yamapp.domain.model.RestaurantMenuItem
import com.saydullin.yamapp.domain.utils.RestaurantMenuCategory
import com.saydullin.yamapp.domain.utils.RestaurantMenuCategoryTranslate
import javax.inject.Inject

class RestaurantMenuItemMapper @Inject constructor()
    :Mapper<RestaurantMenuItem, RestaurantMenuItemEntity>() {

    override fun map(from: RestaurantMenuItem): RestaurantMenuItemEntity {
        return RestaurantMenuItemEntity(
            id = from.id,
            title = from.title,
            description = from.description,
            category = RestaurantMenuCategoryTranslate.executeReverse(from.category),
            image = from.image,
        )
    }

}


