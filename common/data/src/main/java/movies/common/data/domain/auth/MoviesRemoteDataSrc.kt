package movies.common.data.domain.auth

import movies.common.data.model.MoviesRequest
import movies.common.data.model.MoviesResponse

class MoviesRemoteDataSrc(private val api: MoviesApi) {

    suspend fun discoverMovies(request: MoviesRequest): MoviesResponse {
        return api.discoverMovies(  query = request.search, page = request.nextPage)
    }

    suspend fun searchMovies(request: MoviesRequest): MoviesResponse {
        return api.searchMovies(request)
    }

}