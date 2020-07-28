package movies.common.data

import movies.common.data.domain.auth.MoviesRepo
import movies.common.data.pref.SharedPref

open class DataManager(
        val pref: SharedPref,
        val moviesRepo: MoviesRepo
)
