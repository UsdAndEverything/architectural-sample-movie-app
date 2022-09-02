package com.usd.movieapplication.di

import com.usd.movieapplication.data.localdatasource.LocalDataSource
import com.usd.movieapplication.data.localdatasource.LocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalDataSourceModule {

    @Provides
    @Singleton
    fun provideLocalDataSource(): LocalDataSource {
        return LocalDataSourceImpl()
    }

}