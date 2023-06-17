package com.formgrav.mymoviesmvvm.domain.api

import com.formgrav.mymoviesmvvm.domain.models.Movie

interface MoviesInteractor {
    fun searchMovies(expression: String, consumer: MoviesConsumer)

    interface MoviesConsumer {
        fun consume(foundMovies: List<Movie>?, errorMessage: String?)
    }
}