package com.saydullin.yamapp.di

import android.content.Context
import androidx.room.Room
import com.saydullin.yamapp.data.db.dao.RestaurantDao
import com.saydullin.yamapp.data.db.AppDatabase
import com.saydullin.yamapp.data.db.converters.RestaurantMenuListConverter
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

}