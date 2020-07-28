package com.movies.app.shared.di

import com.movies.app.ui.home.tabs.discover.discoverMoviesModule
import com.movies.app.ui.home.homeModule
import com.movies.app.ui.home.tabs.search.searchMoviesModule
import com.movies.app.ui.splash.splashModule
import org.koin.core.context.loadKoinModules

fun injectAppModule() = loadAppModules

private val loadAppModules by lazy {
    loadKoinModules(
            listOf(
                    splashModule,
                    homeModule,
                    discoverMoviesModule,
                    searchMoviesModule
            )
    )
}