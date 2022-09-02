package com.usd.movieapplication.data.remotedatasource

import com.usd.movieapplication.data.network.ApiService
import com.usd.movieapplication.model.movie.Movie
import com.usd.movieapplication.model.movie.MovieList
import retrofit2.Response

class RemoteDataSourceImpl(private val apiService: ApiService) : RemoteDataSource {

    override suspend fun getMovieList(): Response<MovieList> {
        return apiService.getMovieList()
    }

}