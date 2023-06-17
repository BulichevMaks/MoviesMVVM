package com.formgrav.mymoviesmvvm.data

import com.formgrav.mymoviesmvvm.data.dto.MoviesSearchRequest
import com.formgrav.mymoviesmvvm.data.dto.MoviesSearchResponse
import com.formgrav.mymoviesmvvm.domain.api.MoviesRepository
import com.formgrav.mymoviesmvvm.domain.models.Movie
import com.formgrav.mymoviesmvvm.util.Resource


class MoviesRepositoryImpl(private val networkClient: NetworkClient) : MoviesRepository {

    override fun searchMovies(expression: String): Resource<List<Movie>> {
        val response = networkClient.doRequest(MoviesSearchRequest(expression))
        return when (response.resultCode) {
            -1 -> {
                Resource.Error("Проверьте подключение к интернету")
            }
            200 -> {
                if ((response as MoviesSearchResponse).results.isNotEmpty()) {
                    return Resource.Success((response).results.map {
                        Movie(it.id, it.resultType, it.image, it.title, it.description)
                    })
                } else {
                    return Resource.Error("Ни чего не найдено")
                }
            }
            else -> {
                Resource.Error("Ошибка сервера")
            }
        }
    }
}