package com.usd.movieapplication.data.network

import com.usd.movieapplication.BuildConfig
import com.usd.movieapplication.model.movie.Movie
import com.usd.movieapplication.model.movie.MovieList
import com.usd.movieapplication.util.Constants.GET_MOVIES
import com.usd.movieapplication.util.Constants.QUERY_PARAM_API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET(GET_MOVIES)
    suspend fun getMovieList(
        @Query(QUERY_PARAM_API_KEY) apiKey: String = BuildConfig.API_KEY
    ): Response<MovieList>

}