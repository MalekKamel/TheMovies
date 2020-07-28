package com.movies.app.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import movies.common.data.DataManager
import movies.common.data.model.MoviesRequest
import movies.common.data.model.MoviesResponse
import movies.common.presentation.ui.vm.BaseViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Sha on 7/28/20.
 */

val homeModule = module {
    viewModel { HomeViewModel(get()) }
}

class HomeViewModel(dataManager: DataManager) : BaseViewModel(dataManager)