package com.saydullin.yamapp.domain.mapper

import com.saydullin.yamapp.data.db.entities.CartEntity
import com.saydullin.yamapp.data.db.entities.UserEntity
import com.saydullin.yamapp.domain.model.Cart
import com.saydullin.yamapp.domain.model.User
import com.saydullin.yamapp.domain.utils.RestaurantMenuCategory
import com.saydullin.yamapp.domain.utils.RestaurantMenuCategoryTranslate
import javax.inject.Inject

class CartEntityMapper @Inject constructor():
    Mapper<CartEntity, Cart>() {

    override fun map(from: CartEntity): Cart {
        return Cart(
            id = from.id,
            menuItemId = from.menuItem.id,
            menuItemTitle = from.menuItem.title,
            menuItemDescription = from.menuItem.description,
            menuItemCategory = RestaurantMenuCategoryTranslate.execute(from.menuItem.category),
            menuItemImage = from.menuItem.image,
        )
    }

}


