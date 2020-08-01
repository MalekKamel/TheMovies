package com.movies.app.ui.home.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.movies.app.R
import kotlinx.android.synthetic.main.item_movie.view.*
import movies.common.core.picasso.PicassoUtil
import movies.common.data.model.Movie
import movies.common.presentation.ui.adapter.BasePagedListAdapter
import movies.common.presentation.ui.adapter.BaseViewHolder
import movies.common.presentation.ui.view.ViewInterface


/**
 * Created by Sha on 4/20/17.
 */

class MoviesAdapter(baseView: ViewInterface) : BasePagedListAdapter<Movie>(
        baseView,
        object : DiffUtil.ItemCallback<Movie>() {
            override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem == newItem
            }
        }) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Movie> {
        return Vh(parent)
    }

    inner class Vh internal constructor(viewGroup: ViewGroup)
        : BaseViewHolder<Movie>(viewGroup, R.layout.item_movie) {

        override fun bindView(item: Movie) {
            itemView.tvTitle.text = item.title
            itemView.tvReleaseDate.text = item.releaseDate
            itemView.tvOverview.text = item.overview
            PicassoUtil.load(
                    iv =itemView.ivPoster,
                    url = item.poster()
            )
        }

    }
}
