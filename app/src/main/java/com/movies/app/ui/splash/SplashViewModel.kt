package com.movies.app.ui.splash

import movies.common.data.DataManager
import movies.common.presentation.ui.vm.BaseViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Sha on 7/28/20.
 */

val splashModule = module {
    viewModel { SplashViewModel(get()) }
}

class SplashViewModel(dataManager: DataManager) : BaseViewModel(dataManager)