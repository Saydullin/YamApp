package com.saydullin.yamapp.domain.mapper

import com.saydullin.yamapp.data.db.entities.UserEntity
import com.saydullin.yamapp.domain.model.User
import javax.inject.Inject

class UserMapper @Inject constructor():
    Mapper<User, UserEntity>() {

    override fun map(from: User): UserEntity {
        return UserEntity(
            id = from.id,
            username = from.username,
            age = from.age,
            isRegistered = from.isRegistered,
        )
    }

}


