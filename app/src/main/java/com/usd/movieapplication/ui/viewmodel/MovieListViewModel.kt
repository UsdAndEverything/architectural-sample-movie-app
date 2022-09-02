package com.usd.movieapplication.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.usd.movieapplication.R
import com.usd.movieapplication.data.Resource
import com.usd.movieapplication.domain.usecase.GetMovieListUseCase
import com.usd.movieapplication.model.movie.Movie
import com.usd.movieapplication.model.movie.MovieList
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class MovieListViewModel(
    private val app: Application,
    private val getMovieListUseCase: GetMovieListUseCase
) : AndroidViewModel(app) {

    val movieList = MutableLiveData<Resource<MovieList>>()

    fun getMovieList() {
        movieList.postValue(Resource.Loading(app.getString(R.string.text_please_wait)))

        viewModelScope.launch(IO) {
            val data = getMovieListUseCase.execute()
            movieList.postValue(data)
        }
    }

}