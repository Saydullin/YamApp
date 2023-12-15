package com.saydullin.yamapp.domain.usecase

import com.saydullin.yamapp.domain.model.Restaurant
import com.saydullin.yamapp.domain.repository.RestaurantRepository
import com.saydullin.yamapp.domain.utils.Resource
import javax.inject.Inject

class GetRestaurantUseCase @Inject constructor(
    private val restaurantRepository: RestaurantRepository
) {

    suspend fun execute(): Resource<List<Restaurant>> {
        return restaurantRepository.getRestaurants()
    }

}


