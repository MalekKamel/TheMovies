package movies.common.data.domain.movies

import movies.common.data.model.LoadType
import movies.common.data.model.Movie
import movies.common.data.model.MoviesRequest
import movies.common.data.model.MoviesResponse

class MoviesRepo(private val remoteSrc: MoviesRemoteDataSrc, private val localSrc: MoviesLocalDataSrc) {

    suspend fun discoverMovies(request: MoviesRequest): MoviesResponse {
        return remoteSrc.discoverMovies(request)
    }

    suspend fun searchMovies(request: MoviesRequest, type: LoadType): List<Movie> {
        return when (type) {
            LoadType.LOCAL -> {
                localSrc.all()
            }
            LoadType.REMOTE -> {
                remoteSrc.searchMovies(request).results
            }
        }
    }

    suspend fun save(movies: List<Movie>) {
        localSrc.save(movies)
    }

    suspend fun deleteAll() {
        localSrc.deleteAll()
    }

}
