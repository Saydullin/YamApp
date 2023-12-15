package com.saydullin.yamapp.domain.usecase

import com.saydullin.yamapp.domain.model.Cart
import com.saydullin.yamapp.domain.repository.CartRepository
import com.saydullin.yamapp.domain.utils.Resource
import javax.inject.Inject

class SaveCartItemUseCase @Inject constructor(
    private val cartRepository: CartRepository
) {

    suspend fun execute(cart: Cart): Resource<Unit> {
        return cartRepository.saveCartItem(cart)
    }

}