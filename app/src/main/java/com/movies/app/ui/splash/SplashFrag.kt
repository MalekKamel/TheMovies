package com.movies.app.ui.splash

import android.os.Handler
import android.os.Looper
import androidx.navigation.fragment.findNavController
import com.movies.app.R
import movies.common.presentation.ui.frag.BaseFrag
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * Created by Sha on 7/28/20.
 */

class SplashFrag : BaseFrag<SplashViewModel>() {
    override var layoutId: Int = R.layout.frag_splash
    override val vm: SplashViewModel by viewModel()

    override fun onResume() {
        super.onResume()
        setupFlow()
    }

    private fun setupFlow() {
        Handler(Looper.getMainLooper()).postDelayed({
            showHome()
        }, 2000)
    }

    private fun showHome() {
        findNavController().navigate(R.id.action_splashFrag_to_homeFrag)
    }

}
