package com.usd.movieapplication.di

import com.usd.movieapplication.data.network.ApiService
import com.usd.movieapplication.data.remotedatasource.RemoteDataSource
import com.usd.movieapplication.data.remotedatasource.RemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteDataSourceModule {

    @Provides
    @Singleton
    fun provideRemoteDataSourceModule(apiService: ApiService): RemoteDataSource {
        return RemoteDataSourceImpl(apiService)
    }

}