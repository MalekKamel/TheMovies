package com.movies.app.ui.home

import android.os.Bundle
import android.view.View
import com.movies.app.R
import com.movies.app.ui.home.tabs.HomeTabsAdapter
import kotlinx.android.synthetic.main.frag_home.*
import movies.common.presentation.ui.frag.BaseFrag
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * Created by Sha on 7/28/20.
 */

class HomeFrag : BaseFrag<HomeViewModel>() {
    override var layoutId: Int = R.layout.frag_home
    override val vm: HomeViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewPager()
    }

    private fun setupViewPager() {
        viewPager.adapter = HomeTabsAdapter(childFragmentManager)
        tabLayout.setupWithViewPager(viewPager)
    }

}