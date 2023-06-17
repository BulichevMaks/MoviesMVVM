package com.formgrav.mymoviesmvvm.domain.api

import com.formgrav.mymoviesmvvm.domain.models.Movie
import com.formgrav.mymoviesmvvm.util.Resource


interface MoviesRepository {
    fun searchMovies(expression: String): Resource<List<Movie>>
}