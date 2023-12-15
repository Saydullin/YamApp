package com.saydullin.yamapp.data.repository

import com.saydullin.yamapp.data.db.dao.CartDao
import com.saydullin.yamapp.domain.mapper.CartEntityMapper
import com.saydullin.yamapp.domain.mapper.CartMapper
import com.saydullin.yamapp.domain.model.Cart
import com.saydullin.yamapp.domain.repository.CartRepository
import com.saydullin.yamapp.domain.utils.Resource
import com.saydullin.yamapp.domain.utils.StatusType
import javax.inject.Inject

class CartRepositoryImpl @Inject constructor(
    override val cartDao: CartDao,
    override val cartEntityMapper: CartEntityMapper,
    override val cartMapper: CartMapper
): CartRepository {

    override suspend fun getCart(): Resource<List<Cart>> {
        return try {
            val cartMapped = cartDao.getCart().map { cartEntityMapper.map(it) }
            Resource.Success(cartMapped)
        } catch (e: Exception) {
            Resource.Error(StatusType.DATABASE_ERROR)
        }

    }

    override suspend fun removeCartItem(id: Int): Resource<Unit> {
        return try {
            cartDao.removeCartItem(id)
            Resource.Success(Unit)
        } catch (e: Exception) {
            Resource.Error(StatusType.DATABASE_ERROR)
        }
    }

    override suspend fun saveCartItem(cart: Cart): Resource<Unit> {
        return try {
            val cartMapped = cartMapper.map(cart)
            cartDao.saveCartItem(cartMapped)
            Resource.Success(Unit)
        } catch (e: Exception) {
            Resource.Error(StatusType.DATABASE_ERROR)
        }
    }

}