package movies.common.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sha.modelmapper.Mapper

@Entity(tableName = "movies")
data class MovieEntity(
        @PrimaryKey
        var id: Int,
        var title: String?,
        var overview: String?,
        var releaseDate: String?,
        var posterPath: String?
)

class MovieEntityMapper : Mapper<Movie, MovieEntity> {
    override fun map(input: Movie): MovieEntity {
        return MovieEntity(
                id = input.id,
                title = input.title,
                overview = input.overview,
                releaseDate = input.releaseDate,
                posterPath = input.posterPath
        )
    }
}

class MovieMapper : Mapper<MovieEntity, Movie> {
    override fun map(input: MovieEntity): Movie {
        return Movie(
                id = input.id,
                title = input.title,
                overview = input.overview,
                releaseDate = input.releaseDate,
                posterPath = input.posterPath
        )
    }
}