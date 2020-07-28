package movies.common.presentation.ui.paging

import androidx.paging.PageKeyedDataSource
import movies.common.core.util.Constant

class AppPagedKeyedDataSource<K, V> : PageKeyedDataSource<K, V>() {
     var loadInitial: ((InitialParams<K, V>) -> Unit)? = null
     var loadAfter: ((AfterParams<K, V>) -> Unit)? = null
     var initialLoadSize = Constant.INITIAL_PAGE_SIZE

    internal fun initialLoadSize(size: Int): AppPagedKeyedDataSource<K, V> {
        initialLoadSize = size
        return this
    }

    override fun loadInitial(params: LoadInitialParams<K>, callback: LoadInitialCallback<K, V>) {
        if (isInvalid) return
        loadInitial?.invoke(InitialParams(initialLoadSize = initialLoadSize, callback = callback))
    }

    override fun loadAfter(params: LoadParams<K>, callback: LoadCallback<K, V>) {
        if (isInvalid) return
        loadAfter?.invoke(AfterParams(callback = callback, params = params, key = params.key))
    }

    override fun loadBefore(params: LoadParams<K>, callback: LoadCallback<K, V>) {}

    companion object {
        fun <K, V> create(block: AppPagedKeyedDataSource<K, V>.() -> Unit): AppPagedKeyedDataSource<K, V> {
            return AppPagedKeyedDataSource<K, V>().apply(block)
        }
    }

}