package movies.common.data.model

import com.google.gson.annotations.SerializedName

data class Movie(
        @field:SerializedName("id")
        var id: Int,

        @field:SerializedName("title")
        var title: String?,

        @field:SerializedName("overview")
        var overview: String?,

        @field:SerializedName("release_date")
        var releaseDate: String?,

        @SerializedName("poster_path")
        var posterPath: String?
) {
    fun poster(): String? {
        if (posterPath == null) return null
        return "https://image.tmdb.org/t/p/w500$posterPath"
    }
}
