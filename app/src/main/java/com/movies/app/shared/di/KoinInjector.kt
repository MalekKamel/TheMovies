package com.movies.app.shared.di

import android.content.Context
import movies.common.data.di.injectDataModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

object KoinInjector {

    fun inject(context: Context){
        startKoin {
            androidContext(context)
        }
        injectAppModule()
        injectDataModule()
    }

}