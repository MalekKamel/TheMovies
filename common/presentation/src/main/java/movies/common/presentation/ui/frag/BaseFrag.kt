package movies.common.presentation.ui.frag

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import movies.common.presentation.R
import movies.common.presentation.ui.activity.BaseActivity
import movies.common.presentation.ui.view.ViewInterface
import movies.common.presentation.ui.vm.BaseViewModel
import movies.common.core.util.reportAndPrint

abstract class BaseFrag<VM: BaseViewModel> : Fragment(), ViewInterface {

    abstract val vm: VM

    abstract var layoutId: Int
    open var swipeRefreshLayoutId: Int = 0
    protected open fun doOnViewCreated() {}
    protected fun doOnResume() {}

    open var hasBackNavigation = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupVm()
    }

    private fun setupVm() {
        vm.toggleLoading.observe(this, Observer { show ->
            if (show) {
                showLoadingDialog()
                return@Observer
            }
            dismissLoadingDialogs()
        })
        vm.showError.observe(this, Observer { showErrorInFlashBar(it) })
        vm.showErrorRes.observe(this, Observer { showErrorInFlashBar(it) })
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutId, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        try {
            doOnViewCreated()
        } catch (e: Exception) {
            e.reportAndPrint()
        }
    }

    override fun onResume() {
        super.onResume()
        try {
            doOnResume()
        } catch (e: Exception) {
            e.reportAndPrint()
        }
    }

    override fun activity(): BaseActivity? = activity as? BaseActivity

    fun <T : View> findViewById(@IdRes id: Int): T = activity!!.findViewById(id)
}