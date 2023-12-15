package com.saydullin.yamapp.domain.usecase

import com.saydullin.yamapp.domain.model.Restaurant
import com.saydullin.yamapp.domain.repository.RestaurantRepository
import com.saydullin.yamapp.domain.utils.Resource
import javax.inject.Inject

class SaveRestaurantUseCase @Inject constructor(
    private val restaurantRepository: RestaurantRepository
) {

    suspend fun execute(list: List<Restaurant>) {
        restaurantRepository.saveRestaurants(list)
    }

}


