package movies.common.presentation.navigation

import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import movies.common.presentation.R
import movies.common.presentation.ui.activity.BaseActivity

abstract class NavHostActivity: BaseActivity() {
    override var layoutId: Int = R.layout.activity_nav_host
    abstract var navGraph: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupGraph()
    }

    private fun setupGraph() {
        val finalHost = NavHostFragment.create(navGraph)
        supportFragmentManager.beginTransaction()
                .replace(R.id.navHost, finalHost)
                .commit()
    }
}