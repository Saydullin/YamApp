package com.saydullin.yamapp.domain.mapper

import com.saydullin.yamapp.data.db.entities.RestaurantMenuItemEntity
import com.saydullin.yamapp.domain.model.RestaurantMenuItem
import com.saydullin.yamapp.domain.utils.RestaurantMenuCategory
import com.saydullin.yamapp.domain.utils.RestaurantMenuCategoryTranslate
import javax.inject.Inject

class RestaurantMenuEntityMapper @Inject constructor():
    Mapper<RestaurantMenuItemEntity, RestaurantMenuItem>() {

    override fun map(from: RestaurantMenuItemEntity): RestaurantMenuItem {
        return RestaurantMenuItem(
            id = from.id,
            title = from.title,
            description = from.description,
            category = RestaurantMenuCategoryTranslate.execute(from.category),
            image = from.image,
        )
    }

}


