package com.saydullin.yamapp.domain.mapper

import com.saydullin.yamapp.data.db.entities.CartEntity
import com.saydullin.yamapp.data.db.entities.RestaurantMenuItemEntity
import com.saydullin.yamapp.domain.model.Cart
import com.saydullin.yamapp.domain.utils.RestaurantMenuCategoryTranslate
import javax.inject.Inject

class CartMapper @Inject constructor():
    Mapper<Cart, CartEntity>() {

    override fun map(from: Cart): CartEntity {
        return CartEntity(
            menuItem = RestaurantMenuItemEntity(
                id = from.menuItemId,
                title = from.menuItemTitle,
                description = from.menuItemDescription,
                category = RestaurantMenuCategoryTranslate.executeReverse(from.menuItemCategory),
                image = from.menuItemImage,
            )
        )
    }

}


