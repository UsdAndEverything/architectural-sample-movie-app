package com.usd.movieapplication.domain.usecase

import com.usd.movieapplication.data.Resource
import com.usd.movieapplication.data.repository.MovieRepository
import com.usd.movieapplication.model.movie.Movie
import com.usd.movieapplication.model.movie.MovieList

class GetMovieListUseCase(private val repository: MovieRepository) {

    suspend fun execute(): Resource<MovieList> {
        return repository.getMovieList()
    }

}