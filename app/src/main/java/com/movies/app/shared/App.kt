package com.movies.app.shared

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import androidx.annotation.StringRes
import com.movies.app.R
import com.movies.app.shared.di.KoinInjector
import com.sha.kamel.navigator.NavigatorOptions
import movies.common.core.util.reportAndPrint

/**
 * Created by Sha on 13/04/17.
 */

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        try {

            context = applicationContext

            KoinInjector.inject(this)

        } catch (e: Exception) {
            e.reportAndPrint()
        }

    }

    companion object {

        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context

        @JvmStatic
        fun string(@StringRes res: Int): String {
            return context.getString(res)
        }

    }
}
