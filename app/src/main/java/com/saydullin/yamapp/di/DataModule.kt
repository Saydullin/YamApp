package com.saydullin.yamapp.di

import android.content.Context
import androidx.room.Room
import com.saydullin.yamapp.data.db.dao.RestaurantDao
import com.saydullin.yamapp.data.db.AppDatabase
import com.saydullin.yamapp.data.db.converters.RestaurantMenuListConverter
import com.saydullin.yamapp.data.db.dao.CartDao
import com.saydullin.yamapp.data.db.dao.UserDao
import com.saydullin.yamapp.data.repository.CartRepositoryImpl
import com.saydullin.yamapp.data.repository.RestaurantRepositoryImpl
import com.saydullin.yamapp.data.repository.UserRepositoryImpl
import com.saydullin.yamapp.domain.mapper.CartEntityMapper
import com.saydullin.yamapp.domain.mapper.CartMapper
import com.saydullin.yamapp.domain.mapper.RestaurantEntityMapper
import com.saydullin.yamapp.domain.mapper.RestaurantMapper
import com.saydullin.yamapp.domain.mapper.RestaurantMenuEntityMapper
import com.saydullin.yamapp.domain.mapper.RestaurantMenuItemMapper
import com.saydullin.yamapp.domain.mapper.UserEntityMapper
import com.saydullin.yamapp.domain.mapper.UserMapper
import com.saydullin.yamapp.domain.repository.CartRepository
import com.saydullin.yamapp.domain.repository.RestaurantRepository
import com.saydullin.yamapp.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "YamAppDatabase"
        )
            .allowMainThreadQueries()
            .addTypeConverter(RestaurantMenuListConverter())
            .build()
    }

    @Provides
    @Singleton
    fun provideRestaurantDao(appDatabase: AppDatabase): RestaurantDao {
        return appDatabase.restaurantDao()
    }

    @Provides
    @Singleton
    fun provideUserDao(appDatabase: AppDatabase): UserDao {
        return appDatabase.userDao()
    }

    @Provides
    @Singleton
    fun provideCartDao(appDatabase: AppDatabase): CartDao {
        return appDatabase.cartDao()
    }

    @Provides
    @Singleton
    fun providesRestaurantRepository(
        restaurantDao: RestaurantDao,
        restaurantEntityMapper: RestaurantEntityMapper,
        restaurantMapper: RestaurantMapper,
        restaurantMenuItemMapper: RestaurantMenuItemMapper
    ): RestaurantRepository {
        return RestaurantRepositoryImpl(
            restaurantDao = restaurantDao,
            restaurantEntityMapper = restaurantEntityMapper,
            restaurantMapper = restaurantMapper,
            restaurantMenuItemMapper = restaurantMenuItemMapper,
        )
    }

    @Provides
    @Singleton
    fun provideUserRepository(
        userDao: UserDao,
        userMapper: UserMapper,
        userEntityMapper: UserEntityMapper,
    ): UserRepository {
        return UserRepositoryImpl(
            userDao = userDao,
            userMapper = userMapper,
            userEntityMapper = userEntityMapper,
        )
    }

    @Provides
    @Singleton
    fun provideCartRepository(
        cartDao: CartDao,
        cartMapper: CartMapper,
        cartEntityMapper: CartEntityMapper,
    ): CartRepository {
        return CartRepositoryImpl(
            cartDao = cartDao,
            cartMapper = cartMapper,
            cartEntityMapper = cartEntityMapper,
        )
    }

}


