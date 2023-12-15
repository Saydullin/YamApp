package com.saydullin.yamapp.di

import com.saydullin.yamapp.data.db.entities.RestaurantEntity
import com.saydullin.yamapp.data.db.entities.RestaurantMenuItemEntity
import com.saydullin.yamapp.data.db.entities.UserEntity
import com.saydullin.yamapp.data.model.RestaurantMenuItemData
import com.saydullin.yamapp.domain.mapper.Mapper
import com.saydullin.yamapp.domain.mapper.RestaurantEntityMapper
import com.saydullin.yamapp.domain.mapper.RestaurantMapper
import com.saydullin.yamapp.domain.mapper.RestaurantMenuEntityMapper
import com.saydullin.yamapp.domain.mapper.RestaurantMenuItemMapper
import com.saydullin.yamapp.domain.mapper.RestaurantMenuMapper
import com.saydullin.yamapp.domain.mapper.UserEntityMapper
import com.saydullin.yamapp.domain.mapper.UserMapper
import com.saydullin.yamapp.domain.model.Restaurant
import com.saydullin.yamapp.domain.model.RestaurantMenuItem
import com.saydullin.yamapp.domain.model.User
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class MapperModule {

    @Binds
    abstract fun bindRestaurantEntityMapper(
        mapper: RestaurantEntityMapper
    ): Mapper<RestaurantEntity, Restaurant>

    @Binds
    abstract fun bindRestaurantMapper(
        mapper: RestaurantMapper
    ): Mapper<Restaurant, RestaurantEntity>

    @Binds
    abstract fun bindRestaurantMenuEntityMapper(
        mapper: RestaurantMenuEntityMapper
    ): Mapper<RestaurantMenuItemEntity, RestaurantMenuItem>

    @Binds
    abstract fun bindRestaurantMenuItemMapper(
        mapper: RestaurantMenuItemMapper
    ): Mapper<RestaurantMenuItem, RestaurantMenuItemEntity>

    @Binds
    abstract fun bindRestaurantMenuMapper(
        mapper: RestaurantMenuMapper
    ): Mapper<RestaurantMenuItem, RestaurantMenuItemData>

    @Binds
    abstract fun bindUserMapper(
        mapper: UserMapper
    ): Mapper<User, UserEntity>

    @Binds
    abstract fun bindUserEntityMapper(
        mapper: UserEntityMapper
    ): Mapper<UserEntity, User>

}