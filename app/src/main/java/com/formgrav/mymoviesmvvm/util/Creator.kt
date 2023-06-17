package com.formgrav.mymoviesmvvm.util

import android.content.Context
import com.formgrav.mymoviesmvvm.data.MoviesRepositoryImpl
import com.formgrav.mymoviesmvvm.data.network.RetrofitNetworkClient
import com.formgrav.mymoviesmvvm.domain.api.MoviesInteractor
import com.formgrav.mymoviesmvvm.domain.api.MoviesRepository
import com.formgrav.mymoviesmvvm.domain.impl.MoviesInteractorImpl
import com.formgrav.mymoviesmvvm.presentation.poster.PosterPresenter
import com.formgrav.mymoviesmvvm.presentation.poster.PosterView


object Creator {
    private fun getMoviesRepository(context: Context): MoviesRepository {
        return MoviesRepositoryImpl(RetrofitNetworkClient(context))
    }

    fun provideMoviesInteractor(context: Context): MoviesInteractor {
        return MoviesInteractorImpl(getMoviesRepository(context))
    }

    fun providePosterPresenter(posterView: PosterView, imageUrl: String): PosterPresenter {
        return PosterPresenter(view = posterView, imageUrl = imageUrl)
    }
}