package pl.marchuck.pagingexample.data

import android.arch.lifecycle.LiveData
import android.arch.paging.DataSource
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import android.arch.paging.RxPagedListBuilder
import pl.marchuck.pagingexample.data.model.Person
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class SwapiPeoplePagedListProvider(private val factory: DataSource.Factory<Int, Person?>) : PagedListProvider<Person?> {

    override fun provide(): LiveData<PagedList<Person?>> {

        return LivePagedListBuilder(factory, PagedList.Config.Builder()
                .setEnablePlaceholders(false)
                .setPageSize(20)
                .setInitialLoadSizeHint(20)
                .build()
        ).setFetchExecutor(createFetchExecutor())
                .build()
    }

    private fun createFetchExecutor(): ExecutorService {
        val nThreads = Runtime.getRuntime().availableProcessors() + 1
        return Executors.newFixedThreadPool(nThreads)
    }
}