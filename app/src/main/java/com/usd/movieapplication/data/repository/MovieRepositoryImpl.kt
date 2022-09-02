package com.usd.movieapplication.data.repository

import com.usd.movieapplication.data.Resource
import com.usd.movieapplication.data.localdatasource.LocalDataSource
import com.usd.movieapplication.data.remotedatasource.RemoteDataSource
import com.usd.movieapplication.model.movie.Movie
import com.usd.movieapplication.model.movie.MovieList
import retrofit2.Response

class MovieRepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : MovieRepository {

    override suspend fun getMovieList(): Resource<MovieList> {
        return responseToResource(remoteDataSource.getMovieList())
    }

    private fun <T> responseToResource(response: Response<T>): Resource<T> {
        if (response.isSuccessful) {
            return Resource.Success(response.body())
        }
        return Resource.Error("An error occurred")
    }
}