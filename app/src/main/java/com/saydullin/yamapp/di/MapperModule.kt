package com.saydullin.yamapp.di

import com.saydullin.yamapp.data.model.RestaurantMenuItemData
import com.saydullin.yamapp.domain.mapper.Mapper
import com.saydullin.yamapp.domain.mapper.RestaurantMenuMapper
import com.saydullin.yamapp.domain.model.RestaurantMenuItem
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class MapperModule {

    @Binds
    abstract fun bindCollectionFeaturedEntityMapper(
        mapper: RestaurantMenuMapper
    ): Mapper<RestaurantMenuItem, RestaurantMenuItemData>

}