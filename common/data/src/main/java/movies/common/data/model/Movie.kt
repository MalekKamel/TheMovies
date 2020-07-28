package movies.common.data.model

import com.google.gson.annotations.SerializedName

data class Movie(
        @SerializedName("poster_path")
        var posterPath: String?,

        @field:SerializedName("adult")
        var isAdult: Boolean,

        @field:SerializedName("overview")
        var overview: String?,

        @field:SerializedName("release_date")
        var releaseDate: String?,

        @field:SerializedName("genre_ids")
        var genreIds: List<Int>?,

        @field:SerializedName("id")
        var id: Int?,

        @field:SerializedName("original_title")
        var originalTitle: String?,

        @field:SerializedName("original_language")
        var originalLanguage: String?,

        @field:SerializedName("title")
        var title: String?,

        @field:SerializedName("backdrop_path")
        var backdropPath: String?,

        @field:SerializedName("popularity")
        var popularity: Double?,

        @field:SerializedName("vote_count")
        var voteCount: Int?,

        @field:SerializedName("video")
        var video: Boolean?,

        @field:SerializedName("vote_average")
        var voteAverage: Double?,

        @Transient var latPage: Int = 0
)
{

        fun poster(): String? {
                if (posterPath == null) return null
                return "https://image.tmdb.org/t/p/w500$posterPath"
        }

        override fun toString(): String = title ?: ""
}
