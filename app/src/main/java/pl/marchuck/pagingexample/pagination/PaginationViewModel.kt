package pl.marchuck.pagingexample.pagination

import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.Observer
import pl.marchuck.pagingexample.App
import pl.marchuck.pagingexample.data.PagedListProvider
import pl.marchuck.pagingexample.data.model.ResultsItem
import pl.marchuck.pagingexample.pagination.adapter.SwapiAdapter

class PaginationViewModel(pagedListProvider: PagedListProvider<ResultsItem?>) : AndroidViewModel(App.get()) {

    private val pagedListData = pagedListProvider.provide()

    val adapter = SwapiAdapter()

    fun observePagedList(owner: LifecycleOwner) {
        pagedListData.observe(owner, Observer { adapter.submitList(it) })
    }

}
