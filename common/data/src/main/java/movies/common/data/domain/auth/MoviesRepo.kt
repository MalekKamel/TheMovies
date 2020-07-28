package movies.common.data.domain.auth

import movies.common.data.model.MoviesRequest
import movies.common.data.model.MoviesResponse

class MoviesRepo(private val src: MoviesRemoteDataSrc) {

   suspend fun discoverMovies(request: MoviesRequest): MoviesResponse {
        return src.discoverMovies(request)
    }

   suspend fun searchMovies(request: MoviesRequest): MoviesResponse{
        return src.searchMovies(request)
    }

}
