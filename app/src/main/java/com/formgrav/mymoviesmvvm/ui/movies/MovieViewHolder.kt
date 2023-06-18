package com.formgrav.mymoviesmvvm.ui.movies

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.formgrav.mymoviesmvvm.R
import com.formgrav.mymoviesmvvm.domain.models.Movie

class MovieViewHolder(
    parent: ViewGroup,
    private val clickListener: MoviesAdapter.MovieClickListener,
) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.list_item_movie, parent, false)
) {

    var cover: ImageView = itemView.findViewById(R.id.cover)
    var title: TextView = itemView.findViewById(R.id.title)
    var description: TextView = itemView.findViewById(R.id.description)
    var inFavoriteToggle: Button = itemView.findViewById(R.id.favorite)

    fun bind(movie: Movie) {
        Glide.with(itemView)
            .load(movie.image)
            .into(cover)

        title.text = movie.title
        description.text = movie.description
        inFavoriteToggle.setText(getFavoriteToggleString(movie.inFavorite))

        itemView.setOnClickListener { clickListener.onMovieClick(movie) }
        inFavoriteToggle.setOnClickListener {
            clickListener.onFavoriteClicked(movie)
        }
    }
    private fun getFavoriteToggleString(inFavorite: Boolean): Int {
        return if (inFavorite) {
            R.string.favorite
        } else {
            R.string.add_to_favorite
        }
    }
}