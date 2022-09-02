package com.usd.movieapplication.ui.viewmodelfactory

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.usd.movieapplication.domain.usecase.GetMovieListUseCase
import com.usd.movieapplication.ui.viewmodel.MovieListViewModel

class MovieListViewModelFactory(private val application: Application, private val getMovieListUseCase: GetMovieListUseCase) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MovieListViewModel::class.java)) {
            return MovieListViewModel(application, getMovieListUseCase) as T
        }
        throw IllegalArgumentException("Unknown view model class")
    }

}