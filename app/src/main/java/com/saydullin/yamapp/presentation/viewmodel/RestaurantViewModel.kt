package com.saydullin.yamapp.presentation.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saydullin.yamapp.domain.model.Restaurant
import com.saydullin.yamapp.domain.model.RestaurantMenuItem
import com.saydullin.yamapp.domain.usecase.GetRestaurantByIdUseCase
import com.saydullin.yamapp.domain.usecase.GetRestaurantUseCase
import com.saydullin.yamapp.domain.usecase.SaveRestaurantUseCase
import com.saydullin.yamapp.domain.usecase.UpdateRestaurantMenuUseCase
import com.saydullin.yamapp.domain.utils.Resource
import com.saydullin.yamapp.domain.utils.StatusType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RestaurantViewModel @Inject constructor(
    private val getRestaurantUseCase: GetRestaurantUseCase,
    private val saveRestaurantUseCase: SaveRestaurantUseCase,
    private val getRestaurantByIdUseCase: GetRestaurantByIdUseCase,
    private val updateRestaurantMenuUseCase: UpdateRestaurantMenuUseCase,
) : ViewModel() {

    private val _restaurants = mutableStateOf<List<Restaurant>?>(null)
    private val _restaurantActive = mutableStateOf<Restaurant?>(null)
    private val _statusType = mutableStateOf<StatusType?>(null)
    val statusType = _statusType
    val restaurants = _restaurants
    val restaurantActive = _restaurantActive

    fun getRestaurants() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val restaurants = getRestaurantUseCase.execute()
                if (restaurants is Resource.Success && restaurants.data != null) {
                    _restaurants.value = restaurants.data
                } else {
                    _statusType.value = restaurants.statusType
                }
            } catch(e: Exception) {
                _statusType.value = StatusType.DATA_ERROR
            }
        }
    }

    fun getRestaurantById(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val restaurant = getRestaurantByIdUseCase.execute(id)
                if (restaurant is Resource.Success && restaurant.data != null) {
                    _restaurantActive.value = restaurant.data
                } else {
                    _statusType.value = restaurant.statusType
                }
            } catch(e: Exception) {
                _statusType.value = StatusType.DATA_ERROR
            }
        }
    }

    fun saveRestaurants(list: List<Restaurant>) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                saveRestaurantUseCase.execute(list)
                _statusType.value = StatusType.SUCCESS
            } catch(e: Exception) {
                _statusType.value = StatusType.DATA_ERROR
            }
        }
    }

    fun updateRestaurantMenu(id: Int, menuItem: RestaurantMenuItem) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val restaurant = getRestaurantByIdUseCase.execute(id)
                if (restaurant is Resource.Success && restaurant.data != null) {
                    val fullMenuItem = ArrayList<RestaurantMenuItem>()
                    fullMenuItem.add(menuItem)
                    fullMenuItem.addAll(restaurant.data.menu)
                    val updatedRest = updateRestaurantMenuUseCase.execute(id, fullMenuItem)
                    if (updatedRest is Resource.Success && updatedRest.data != null) {
                        _statusType.value = StatusType.SUCCESS
                    } else {
                        _statusType.value = updatedRest.statusType
                    }
                } else {
                    _statusType.value = restaurant.statusType
                }
            } catch(e: Exception) {
                e.printStackTrace()
                _statusType.value = StatusType.DATA_ERROR
            }
        }
    }

}


