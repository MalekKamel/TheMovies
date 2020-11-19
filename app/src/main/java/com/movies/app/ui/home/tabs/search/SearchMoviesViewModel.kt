package com.movies.app.ui.home.tabs.search

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import movies.common.data.DataManager
import movies.common.data.model.LoadType
import movies.common.data.model.Movie
import movies.common.data.model.MoviesRequest
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

    fun isValidSearchString(query: String, type: LoadType): Boolean {
        return when (type) {
            LoadType.LOCAL -> true
            LoadType.REMOTE -> query.isNotEmpty()
        }
    }

    fun loadMoviesPaged(request: MoviesRequest, type: LoadType): LiveData<PagedList<Movie>> {
        return Pager.pageKeyed<Int, Movie> {
            loadInitial = { param ->
                loadMovies(request, type) {
                    param.callback.onResult(it, 1, 1)
                }
            }
            loadAfter = { param ->
                loadMovies(request.apply { nextPage = param.key }, type) {
                    param.callback.onResult(it, param.key + 1)
                }
            }
        }
    }

    private fun loadMovies(request: MoviesRequest, type: LoadType, onLoad: (List<Movie>) -> Unit) {
        request {
            val response = dm.moviesRepo.searchMovies(request, type)

            when (type) {
                LoadType.LOCAL -> onLoad(response)
                LoadType.REMOTE -> {
                    if (request.nextPage == 1) dm.moviesRepo.deleteAll()
                    dm.moviesRepo.save(response)
                    onLoad(response)
                }
            }
        }
    }
}