package com.movies.app.ui.home.tabs.discover

import androidx.lifecycle.Observer
import com.movies.app.R
import com.movies.app.ui.home.adapter.MoviesAdapter
import kotlinx.android.synthetic.main.frag_movies_discover.*
import movies.common.core.util.linearLayoutManager
import movies.common.data.model.MoviesRequest
import movies.common.presentation.ui.frag.BaseFrag
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * Created by Sha on 7/28/20.
 */

class DiscoverMoviesFrag : BaseFrag<DiscoverMoviesViewModel>() {
    override var layoutId: Int = R.layout.frag_movies_discover
    override val vm: DiscoverMoviesViewModel by viewModel()
    private val adapter: MoviesAdapter by lazy { MoviesAdapter(this) }

    override fun onResume() {
        super.onResume()
        setupUi()
        loadMovies(MoviesRequest())
    }

    private fun setupUi() {
        rv.linearLayoutManager(context)
    }

    private fun loadMovies(request: MoviesRequest) {
        vm.loadMoviesPaged(request).observe(viewLifecycleOwner, Observer {
            rv.adapter = adapter
            adapter.submitList(it)
        })
    }

}