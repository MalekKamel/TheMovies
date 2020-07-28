package movies.common.data.network.interceptor

import movies.common.data.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response
import movies.common.data.pref.SharedPref
import java.io.IOException

class TokenInterceptor(private val pref: SharedPref) : Interceptor {
    private val token = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJiYTNkOTkzZTNmOGJhOGIzNDJmNTAyZjllZDY5ZTUzMiIsInN1YiI6IjVmMTQzMTViMWM2YWE3MDAzNTgxN2U2ZCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.1R5tfdhb_LC_MqR1SrTDTtJKvWZsSQGC72WFlF4oiOU"

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()

        request = request.newBuilder()
                .addHeader("Authorization", "Bearer ${BuildConfig.API_TOKEN_THE_MOVIE_DB}")
                .build()

        return chain.proceed(request)
    }
}

/*

eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJiYTNkOTkzZTNmOGJhOGIzNDJmNTAyZjllZDY5ZTUzMiIsInN1YiI6IjVmMTQzMTViMWM2YWE3MDAzNTgxN2U2ZCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.1R5tfdhb_LC_MqR1SrTDTtJKvWZsSQGC72WFlF4oiOU
*/