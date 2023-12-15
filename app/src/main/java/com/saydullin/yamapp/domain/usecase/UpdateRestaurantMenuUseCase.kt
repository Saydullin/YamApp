package com.saydullin.yamapp.domain.usecase

import com.saydullin.yamapp.domain.model.RestaurantMenuItem
import com.saydullin.yamapp.domain.repository.RestaurantRepository
import com.saydullin.yamapp.domain.utils.Resource
import javax.inject.Inject

class UpdateRestaurantMenuUseCase @Inject constructor(
    private val restaurantRepository: RestaurantRepository
) {

    suspend fun execute(id: Int, menu: List<RestaurantMenuItem>): Resource<Unit> {
        return restaurantRepository.updateRestaurantMenu(id, menu)
    }

}


