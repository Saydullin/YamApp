package com.saydullin.yamapp.domain.usecase

import com.saydullin.yamapp.domain.repository.CartRepository
import com.saydullin.yamapp.domain.utils.Resource
import javax.inject.Inject

class RemoveCartItemUseCase @Inject constructor(
    private val cartRepository: CartRepository
) {

    suspend fun execute(id: Int): Resource<Unit> {
        return cartRepository.removeCartItem(id)
    }

}