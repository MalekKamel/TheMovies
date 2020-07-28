package com.movies.app.ui.home

import android.os.Bundle
import androidx.lifecycle.Observer
import com.movies.app.R
import movies.common.presentation.ui.frag.BaseFrag
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * Created by Sha on 7/28/20.
 */

class HomeFrag : BaseFrag<HomeViewModel>() {
    override var layoutId: Int = R.layout.activity_home
    override val vm: HomeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        obServeVm()
    }

    private fun obServeVm() {
        vm.onLoadMovies.observe(this, Observer {

        })
    }

    override fun doOnViewCreated() {
        vm.discoverMovies()
    }

}
