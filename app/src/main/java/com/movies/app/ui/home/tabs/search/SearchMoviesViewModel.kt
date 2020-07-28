package com.movies.app.ui.home.tabs.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.PagedList
import movies.common.data.DataManager
import movies.common.data.model.Movie
import movies.common.data.model.MoviesRequest
import movies.common.data.model.MoviesResponse
import movies.common.presentation.ui.paging.Pager
import movies.common.presentation.ui.vm.BaseViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Sha on 7/28/20.
 */

val searchMoviesModule = module {
    viewModel { SearchMoviesViewModel(get()) }
}

class SearchMoviesViewModel(dataManager: DataManager) : BaseViewModel(dataManager) {

    fun isValidSearchString(query: String): Boolean {
        return query.isNotEmpty()
    }

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
            val response = dm.moviesRepo.searchMovies(request)
            onLoad(response.results ?: emptyList())
        }
    }
}