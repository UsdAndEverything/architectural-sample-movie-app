package com.usd.movieapplication.di

import com.usd.movieapplication.data.localdatasource.LocalDataSource
import com.usd.movieapplication.data.remotedatasource.RemoteDataSource
import com.usd.movieapplication.data.repository.MovieRepository
import com.usd.movieapplication.data.repository.MovieRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideMovieRepository(
        localDataSource: LocalDataSource,
        remoteDataSource: RemoteDataSource
    ): MovieRepository {
        return MovieRepositoryImpl(remoteDataSource, localDataSource)
    }

}