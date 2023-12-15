package com.saydullin.yamapp.presentation.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saydullin.yamapp.domain.model.Cart
import com.saydullin.yamapp.domain.usecase.GetCartUseCase
import com.saydullin.yamapp.domain.usecase.RemoveCartItemUseCase
import com.saydullin.yamapp.domain.usecase.SaveCartItemUseCase
import com.saydullin.yamapp.domain.utils.Resource
import com.saydullin.yamapp.domain.utils.StatusType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(
    private val getCartUseCase: GetCartUseCase,
    private val saveCartItemUseCase: SaveCartItemUseCase,
    private val removeCartItemUseCase: RemoveCartItemUseCase
): ViewModel() {

    private val _cart = mutableStateOf<List<Cart>?>(null)
    private val _error = mutableStateOf<StatusType?>(null)
    val cart = _cart
    val error = _error

    fun getCart() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val cartRes = getCartUseCase.execute()
                if (cartRes is Resource.Success) {
                    _cart.value = cartRes.data
                } else {
                    _error.value = cartRes.statusType
                }
            } catch (e: Exception) {
                _error.value = StatusType.DATA_ERROR
            }
        }
    }

    fun saveCartItem(cart: Cart) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val cartRes = saveCartItemUseCase.execute(cart)
                if (cartRes is Resource.Success) {
                    _error.value = StatusType.SUCCESS
                } else {
                    _error.value = cartRes.statusType
                }
            } catch (e: Exception) {
                _error.value = StatusType.DATA_ERROR
            }
        }
    }

    fun removeCartItem(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val cartRes = removeCartItemUseCase.execute(id)
                if (cartRes is Resource.Success) {
                    _error.value = StatusType.SUCCESS
                } else {
                    _error.value = cartRes.statusType
                }
            } catch (e: Exception) {
                _error.value = StatusType.DATA_ERROR
            }
        }
    }

}