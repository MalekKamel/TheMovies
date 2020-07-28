package movies.common.presentation.ui.paging

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PageKeyedDataSource
import androidx.paging.PagedList
import movies.common.core.util.Constant

object Pager {
    fun <K, V> pageKeyed(block: AppPagedKeyedDataSource<K, V>.() -> Unit): LiveData<PagedList<V>> {
        val dataSource = AppPagedKeyedDataSource.create(block)
        val config = PagedList.Config.Builder()
            .setPageSize(Constant.PAGE_SIZE)
            .setEnablePlaceholders(false)
            .build()
        return LivePagedListBuilder(DataSourceFactory { dataSource }, config).build()
    }
}

data class InitialParams<K, V>(
    var initialLoadSize: Int = 0,
    var callback: PageKeyedDataSource.LoadInitialCallback<K, V>
)

class DataSourceFactory<K, V>(private val dataSource: () -> DataSource<K, V>) : DataSource.Factory<K, V>() {
    override fun create(): DataSource<K, V> {
        return dataSource()
    }
}

data class AfterParams<K, V>(
    var callback: PageKeyedDataSource.LoadCallback<K, V>,
    var params: PageKeyedDataSource.LoadParams<K>,
    val key: K
)