package com.movies.app.ui.home.tabs

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.movies.app.R
import com.movies.app.shared.App
import com.movies.app.ui.home.tabs.discover.DiscoverMoviesFrag
import com.movies.app.ui.home.tabs.search.SearchMoviesFrag


class HomeTabsAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getCount(): Int  = 2

    override fun getItem(position: Int): Fragment {
       return when(position) {
            0 -> DiscoverMoviesFrag()
            1 -> SearchMoviesFrag()
           else -> throw IllegalStateException()
       }
    }

    override fun getPageTitle(position: Int): CharSequence {
        return when(position) {
            0 -> App.string(R.string.search)
            1 -> App.string(R.string.discover)
            else -> throw IllegalStateException()
        }
    }
}