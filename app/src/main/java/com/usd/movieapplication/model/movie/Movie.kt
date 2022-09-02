package com.usd.movieapplication.model.movie

data class Movie(
    val id: Int,
    val overview: String?,
    val posterPath: String?,
    val releaseDate: String?,
    val title: String?
)