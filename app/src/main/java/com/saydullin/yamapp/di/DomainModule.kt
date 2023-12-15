package com.saydullin.yamapp.di

import com.saydullin.yamapp.domain.repository.CartRepository
import com.saydullin.yamapp.domain.repository.RestaurantRepository
import com.saydullin.yamapp.domain.repository.UserRepository
import com.saydullin.yamapp.domain.usecase.GetCartUseCase
import com.saydullin.yamapp.domain.usecase.GetRestaurantByIdUseCase
import com.saydullin.yamapp.domain.usecase.GetRestaurantUseCase
import com.saydullin.yamapp.domain.usecase.GetUserUseCase
import com.saydullin.yamapp.domain.usecase.RemoveCartItemUseCase
import com.saydullin.yamapp.domain.usecase.SaveCartItemUseCase
import com.saydullin.yamapp.domain.usecase.SaveRestaurantUseCase
import com.saydullin.yamapp.domain.usecase.SaveUserUseCase
import com.saydullin.yamapp.domain.usecase.UpdateRestaurantMenuUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {

    @Provides
    fun providesGetRestaurantUseCase(
        restaurantRepository: RestaurantRepository
    ): GetRestaurantUseCase {
        return GetRestaurantUseCase(
            restaurantRepository = restaurantRepository
        )
    }

    @Provides
    fun provideSaveRestaurantUseCase(
        restaurantRepository: RestaurantRepository
    ): SaveRestaurantUseCase {
        return SaveRestaurantUseCase(
            restaurantRepository = restaurantRepository
        )
    }

    @Provides
    fun provideGetUserUseCase(
        userRepository: UserRepository
    ): GetUserUseCase {
        return GetUserUseCase(
            userRepository = userRepository
        )
    }

    @Provides
    fun provideSaveUserUseCase(
        userRepository: UserRepository
    ): SaveUserUseCase {
        return SaveUserUseCase(
            userRepository = userRepository
        )
    }

    @Provides
    fun provideGetRestaurantByIdUseCase(
        restaurantRepository: RestaurantRepository
    ): GetRestaurantByIdUseCase {
        return GetRestaurantByIdUseCase(
            restaurantRepository = restaurantRepository
        )
    }

    @Provides
    fun provideUpdateRestaurantMenuUseCase(
        restaurantRepository: RestaurantRepository
    ): UpdateRestaurantMenuUseCase {
        return UpdateRestaurantMenuUseCase(
            restaurantRepository = restaurantRepository
        )
    }

    @Provides
    fun provideGetCartUseCase(
        cartRepository: CartRepository
    ): GetCartUseCase {
        return GetCartUseCase(
            cartRepository = cartRepository
        )
    }

    @Provides
    fun provideSaveCartItemUseCase(
        cartRepository: CartRepository
    ): SaveCartItemUseCase {
        return SaveCartItemUseCase(
            cartRepository = cartRepository
        )
    }

    @Provides
    fun provideRemoveCartItemUseCase(
        cartRepository: CartRepository
    ): RemoveCartItemUseCase {
        return RemoveCartItemUseCase(
            cartRepository = cartRepository
        )
    }

}


