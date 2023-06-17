package com.formgrav.mymoviesmvvm.presentation.movies

import com.formgrav.mymoviesmvvm.ui.movies.models.MoviesState

interface MoviesView {
    fun render(state: MoviesState)

    fun showToast(additionalMessage: String)
}