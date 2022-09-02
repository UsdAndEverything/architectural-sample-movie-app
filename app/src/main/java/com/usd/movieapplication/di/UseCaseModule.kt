package com.usd.movieapplication.di

import com.usd.movieapplication.data.repository.MovieRepository
import com.usd.movieapplication.domain.usecase.GetMovieListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    @Singleton
    fun provideGetMovieListCase(repository: MovieRepository): GetMovieListUseCase {
        return GetMovieListUseCase(repository)
    }

}