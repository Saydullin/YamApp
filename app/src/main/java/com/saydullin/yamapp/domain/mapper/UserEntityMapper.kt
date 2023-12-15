package com.saydullin.yamapp.domain.mapper

import com.saydullin.yamapp.data.db.entities.UserEntity
import com.saydullin.yamapp.domain.model.User
import javax.inject.Inject

class UserEntityMapper @Inject constructor():
    Mapper<UserEntity, User>() {

    override fun map(from: UserEntity): User {
        return User(
            id = from.id,
            username = from.username,
            age = from.age,
            isRegistered = from.isRegistered,
        )
    }

}


