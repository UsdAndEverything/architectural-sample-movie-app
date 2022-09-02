package com.usd.movieapplication.di

import android.app.Application
import com.usd.movieapplication.App
import com.usd.movieapplication.domain.usecase.GetMovieListUseCase
import com.usd.movieapplication.ui.viewmodelfactory.MovieListViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ViewModelFactoryModule {

    @Provides
    @Singleton
    fun provideMovieListViewModelFactory(
        getMovieListUseCase: GetMovieListUseCase
    ): MovieListViewModelFactory {
        return MovieListViewModelFactory(App.app, getMovieListUseCase)
    }

}