package com.saydullin.yamapp.domain.usecase

import com.saydullin.yamapp.domain.model.Cart
import com.saydullin.yamapp.domain.repository.CartRepository
import com.saydullin.yamapp.domain.utils.Resource
import javax.inject.Inject

class GetCartUseCase @Inject constructor(
    private val cartRepository: CartRepository
) {

    suspend fun execute(): Resource<List<Cart>> {
        return cartRepository.getCart()
    }

}