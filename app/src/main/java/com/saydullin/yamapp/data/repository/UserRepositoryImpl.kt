package com.saydullin.yamapp.data.repository

import android.util.Log
import android.widget.Toast
import com.saydullin.yamapp.data.db.dao.UserDao
import com.saydullin.yamapp.domain.mapper.UserEntityMapper
import com.saydullin.yamapp.domain.mapper.UserMapper
import com.saydullin.yamapp.domain.model.User
import com.saydullin.yamapp.domain.repository.UserRepository
import com.saydullin.yamapp.domain.utils.Resource
import com.saydullin.yamapp.domain.utils.StatusType
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    override val userDao: UserDao,
    override val userMapper: UserMapper,
    override val userEntityMapper: UserEntityMapper,
): UserRepository {

    override suspend fun getUser(): Resource<User> {
        return try {
            val userEntity = userDao.getUser()
            Log.e("sady", userEntity.toString())
            if (userEntity != null) {
                val user = userEntityMapper.map(userEntity)
                Resource.Success(user)
            } else {
                val user = User(
                    username = "",
                    age = -1,
                    isRegistered = false
                )
                Resource.Success(user)
            }
        } catch (e: Exception) {
            Resource.Error(StatusType.DATABASE_ERROR)
        }
    }

    override suspend fun saveUser(user: User): Resource<Unit> {
        return try {
            val userEntity = userMapper.map(user)
            userDao.saveUser(userEntity)
            Resource.Success(Unit)
        } catch(e: Exception) {
            Resource.Error(StatusType.DATABASE_ERROR)
        }
    }

}