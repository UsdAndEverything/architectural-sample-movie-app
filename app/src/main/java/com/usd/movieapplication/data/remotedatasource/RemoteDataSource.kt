package com.usd.movieapplication.data.remotedatasource

import com.usd.movieapplication.model.movie.Movie
import com.usd.movieapplication.model.movie.MovieList
import retrofit2.Response

interface RemoteDataSource {

    suspend fun getMovieList(): Response<MovieList>

}