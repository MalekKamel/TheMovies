package movies.common.data.di

import android.preference.PreferenceManager
import movies.common.data.BuildConfig
import movies.common.data.DataManager
import movies.common.data.domain.auth.MoviesApi
import movies.common.data.domain.auth.MoviesRemoteDataSrc
import movies.common.data.domain.auth.MoviesRepo
import movies.common.data.network.interceptor.TokenInterceptor
import movies.common.data.pref.SharedPref
import movies.common.data.rx.SchedulerProvider
import movies.common.data.rx.SchedulerProviderImpl
import movies.common.data.util.RetrofitHelper
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

fun injectDataModule() = loadModule

private val loadModule by lazy {
    loadKoinModules(
            listOf(
                    dataManagerModule,
                    prefModule,
                    okHttpModule,
                    moviesModule
            )
    )
}

val dataManagerModule = module {
    single {
        DataManager(
                pref = get(),
                moviesRepo = get()
        )
    }
}

val okHttpModule = module {
    single {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY


        val builder = OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .addInterceptor(get<TokenInterceptor>())
        builder.build()
    }

    single<SchedulerProvider> { SchedulerProviderImpl() }
    single { TokenInterceptor(get()) }
}

val prefModule = module {
    single { SharedPref(get()) }
    single { PreferenceManager.getDefaultSharedPreferences(androidContext()) }
}

val moviesModule = module {
    single {
        RetrofitHelper.createService(BuildConfig.API_BASE_URL, get(), MoviesApi::class.java)
    }
    factory { MoviesRemoteDataSrc(get()) }
    factory { MoviesRepo(get()) }
}