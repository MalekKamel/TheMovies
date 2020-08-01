package com.movies.app.ui.home.tabs.search

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.movies.app.R
import com.movies.app.ui.home.adapter.MoviesAdapter
import kotlinx.android.synthetic.main.frag_movies_discover.rv
import kotlinx.android.synthetic.main.frag_movies_search.*
import movies.common.core.util.linearLayoutManager
import movies.common.core.util.textString
import movies.common.data.model.LoadType
import movies.common.data.model.MoviesRequest
import movies.common.presentation.ui.frag.BaseFrag
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * Created by Sha on 7/28/20.
 */

class SearchMoviesFrag : BaseFrag<SearchMoviesViewModel>() {
    override var layoutId: Int = R.layout.frag_movies_search
    override val vm: SearchMoviesViewModel by viewModel()
    private val adapter: MoviesAdapter by lazy { MoviesAdapter(this) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUi()
        loadMovies(LoadType.LOCAL)
    }

    private fun setupUi() {
        rv.linearLayoutManager(context)
        setupSearch()
    }

    private fun setupSearch() {
        btnSearch.setOnClickListener {
            loadMovies()
        }

        etSearch.threshold = 1
    }

    private fun loadMovies(type: LoadType = LoadType.REMOTE) {
        if (!vm.isValidSearchString(etSearch.textString(), type)) return

        val request = MoviesRequest(search = etSearch.textString())
        vm.loadMoviesPaged(request, type).observe(viewLifecycleOwner, Observer {
            rv.adapter = adapter
            adapter.submitList(it)
        })
    }
}