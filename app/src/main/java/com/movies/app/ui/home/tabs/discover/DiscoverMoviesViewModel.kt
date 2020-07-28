package com.movies.app.ui.home.tabs.discover

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import movies.common.data.DataManager
import movies.common.data.model.Movie
import movies.common.data.model.MoviesRequest
import movies.common.presentation.ui.paging.Pager
import movies.common.presentation.ui.vm.BaseViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Sha on 7/28/20.
 */

val discoverMoviesModule = module {
    viewModel { DiscoverMoviesViewModel(get()) }
}

class DiscoverMoviesViewModel(dataManager: DataManager) : BaseViewModel(dataManager) {

    fun loadMoviesPaged(request: MoviesRequest): LiveData<PagedList<Movie>> {
        return Pager.pageKeyed<Int, Movie> {
            loadInitial = { param ->
                // You may find it weird to pass a fake static key here!
                // But you should know that the first key must be NULL in the first query in Shopify!!
                // for this reason we depend on next and set it NULL for the first time
                loadMovies(request) {
                    param.callback.onResult(it, 1, 1)
                }
            }
            loadAfter = { param ->
                loadMovies(request.apply { nextPage = param.key }) {
                    param.callback.onResult(it, param.key + 1)
                }
            }
        }
    }

    private fun loadMovies(request: MoviesRequest, onLoad: (List<Movie>) -> Unit) {
        request {
            val response = dm.moviesRepo.discoverMovies(request)
            onLoad(response.results ?: emptyList())
        }
    }
}