package com.saydullin.yamapp.domain.usecase

import com.saydullin.yamapp.domain.model.Restaurant
import com.saydullin.yamapp.domain.repository.RestaurantRepository
import com.saydullin.yamapp.domain.utils.Resource
import javax.inject.Inject

class GetRestaurantByIdUseCase @Inject constructor(
    private val restaurantRepository: RestaurantRepository
) {

    suspend fun execute(id: Int): Resource<Restaurant> {
        return restaurantRepository.getRestaurantById(id)
    }

}


