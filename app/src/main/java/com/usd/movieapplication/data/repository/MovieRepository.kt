package com.usd.movieapplication.data.repository

import com.usd.movieapplication.data.Resource
import com.usd.movieapplication.model.movie.Movie
import com.usd.movieapplication.model.movie.MovieList

interface MovieRepository {

    suspend fun getMovieList(): Resource<MovieList>

}