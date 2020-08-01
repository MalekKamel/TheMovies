package movies.common.data.domain.movies

import movies.common.data.model.MoviesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApi {

    @GET("discover/movie")
    suspend fun discoverMovies(@Query("page") page: Int): MoviesResponse

    @GET("search/movie")
    suspend fun searchMovies(@Query("query") query: String, @Query("page") page: Int): MoviesResponse

}


