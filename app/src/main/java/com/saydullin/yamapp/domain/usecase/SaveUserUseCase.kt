package com.saydullin.yamapp.domain.usecase

import com.saydullin.yamapp.domain.model.User
import com.saydullin.yamapp.domain.repository.UserRepository
import com.saydullin.yamapp.domain.utils.Resource
import javax.inject.Inject

class SaveUserUseCase @Inject constructor(
    private val userRepository: UserRepository
) {

    suspend fun execute(user: User): Resource<Unit> {
        return userRepository.saveUser(user)
    }

}


