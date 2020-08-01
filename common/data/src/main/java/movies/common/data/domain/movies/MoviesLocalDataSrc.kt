package movies.common.data.domain.movies

import com.sha.modelmapper.ListMapper
import movies.common.data.db.MovieDao
import movies.common.data.db.MovieDatabase
import movies.common.data.model.*

class MoviesLocalDataSrc(private val db: MovieDatabase) {

    suspend fun all(): List<Movie> {
        return db.movieDao().all().map { MovieMapper().map(it) }
    }

    suspend fun save(movies: List<Movie>) {
        db.movieDao().insert(ListMapper(MovieEntityMapper()).map(movies))
    }

    suspend fun deleteAll() {
        db.movieDao().deleteAll()
    }

}