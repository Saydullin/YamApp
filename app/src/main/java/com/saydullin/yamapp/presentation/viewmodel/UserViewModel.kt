package com.saydullin.yamapp.presentation.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saydullin.yamapp.domain.model.User
import com.saydullin.yamapp.domain.usecase.GetUserUseCase
import com.saydullin.yamapp.domain.usecase.SaveUserUseCase
import com.saydullin.yamapp.domain.utils.Resource
import com.saydullin.yamapp.domain.utils.StatusType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val getUserUseCase: GetUserUseCase,
    private val saveUserUseCase: SaveUserUseCase,
): ViewModel() {

    private val _user = mutableStateOf<User?>(null)
    private val _getUserStatus = mutableStateOf<StatusType?>(null)
    private val _saveUserStatus = mutableStateOf<StatusType?>(null)
    val user = _user
    val getUserStatus = _getUserStatus
    val saveUserStatus = _saveUserStatus

    fun resetSaveUserStatus() {
        _saveUserStatus.value = null
    }

    fun resetGetUserStatus() {
        _getUserStatus.value = null
    }

    fun getUser() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val userGetInfo = getUserUseCase.execute()
                if (userGetInfo is Resource.Success && userGetInfo.data != null) {
                    _user.value = userGetInfo.data
                    _getUserStatus.value = StatusType.SUCCESS
                } else {
                    _getUserStatus.value = userGetInfo.statusType
                }
            } catch (e: Exception) {
                _getUserStatus.value = StatusType.DATA_ERROR
            }
        }
    }

    fun saveUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val userSaveInfo = saveUserUseCase.execute(user)
                if (userSaveInfo is Resource.Success) {
                    _saveUserStatus.value = StatusType.SUCCESS
                } else {
                    _saveUserStatus.value = userSaveInfo.statusType
                }
            } catch (e: Exception) {
                _saveUserStatus.value = StatusType.DATA_ERROR
            }
        }
    }

}


