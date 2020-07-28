package movies.common.data.domain.auth

import movies.common.data.model.MoviesRequest
import movies.common.data.model.MoviesResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApi {

    @GET("discover/movie")
    suspend fun discoverMovies(@Query("query") query: String,
                               @Query("page") page: Int
    ): MoviesResponse

    @GET("search/movie")
    suspend fun searchMovies(@Body request: MoviesRequest): MoviesResponse

}


