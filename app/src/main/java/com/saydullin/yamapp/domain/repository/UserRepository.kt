package com.saydullin.yamapp.domain.repository

import com.saydullin.yamapp.data.db.dao.UserDao
import com.saydullin.yamapp.domain.mapper.UserEntityMapper
import com.saydullin.yamapp.domain.mapper.UserMapper
import com.saydullin.yamapp.domain.model.User
import com.saydullin.yamapp.domain.utils.Resource

interface UserRepository {

    val userDao: UserDao
    val userMapper: UserMapper
    val userEntityMapper: UserEntityMapper

    suspend fun getUser(): Resource<User>

    suspend fun saveUser(user: User): Resource<Unit>

}