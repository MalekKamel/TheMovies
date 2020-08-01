package movies.common.data.model

data class MoviesRequest (
        var search: String = "",
        var nextPage: Int = 1
)
