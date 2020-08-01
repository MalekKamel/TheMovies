package movies.common.data

import movies.common.data.domain.movies.MoviesRepo
import movies.common.data.pref.SharedPref

open class DataManager(
        val pref: SharedPref,
        val moviesRepo: MoviesRepo
)
