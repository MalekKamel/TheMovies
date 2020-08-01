package movies.common.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import movies.common.data.model.MovieEntity

@Dao
interface MovieDao {

    @Query("SELECT * FROM movies")
    suspend fun all(): List<MovieEntity>

    @Insert
    suspend fun insert(movie: MovieEntity)

    @Insert
    suspend fun insert(movies: List<MovieEntity>)

    @Delete
    suspend fun delete(movie: MovieEntity)

    @Query("DELETE FROM movies")
    suspend fun deleteAll()
}