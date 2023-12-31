package com.formgrav.mymoviesmvvm.domain.impl

import com.formgrav.mymoviesmvvm.domain.api.MoviesInteractor
import com.formgrav.mymoviesmvvm.domain.api.MoviesRepository
import com.formgrav.mymoviesmvvm.domain.models.Movie
import com.formgrav.mymoviesmvvm.util.Resource
import java.util.concurrent.Executors


class MoviesInteractorImpl(private val repository: MoviesRepository) : MoviesInteractor {

    private val executor = Executors.newCachedThreadPool()

    override fun searchMovies(expression: String, consumer: MoviesInteractor.MoviesConsumer) {
        executor.execute {
            when(val resource = repository.searchMovies(expression)) {
                is Resource.Success -> { consumer.consume(resource.data, null) }
                is Resource.Error -> { consumer.consume(null, resource.message) }
            }
        }
    }

    override fun addMovieToFavorites(movie: Movie) {
        repository.addMovieToFavorites(movie)
    }

    override fun removeMovieFromFavorites(movie: Movie) {
        repository.removeMovieFromFavorites(movie)
    }
}