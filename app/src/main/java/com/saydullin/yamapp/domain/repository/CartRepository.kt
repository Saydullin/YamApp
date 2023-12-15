package com.saydullin.yamapp.domain.repository

import com.saydullin.yamapp.data.db.dao.CartDao
import com.saydullin.yamapp.domain.mapper.CartEntityMapper
import com.saydullin.yamapp.domain.mapper.CartMapper
import com.saydullin.yamapp.domain.model.Cart
import com.saydullin.yamapp.domain.utils.Resource

interface CartRepository {

    val cartDao: CartDao
    val cartEntityMapper: CartEntityMapper
    val cartMapper: CartMapper

    suspend fun getCart(): Resource<List<Cart>>

    suspend fun removeCartItem(id: Int): Resource<Unit>

    suspend fun saveCartItem(cart: Cart): Resource<Unit>

}