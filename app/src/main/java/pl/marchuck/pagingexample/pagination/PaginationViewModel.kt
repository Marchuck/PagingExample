package pl.marchuck.pagingexample.pagination

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModel
import pl.marchuck.pagingexample.data.PagedListProvider
import pl.marchuck.pagingexample.data.model.Person
import pl.marchuck.pagingexample.pagination.adapter.SwapiAdapter

class PaginationViewModel(pagedListProvider: PagedListProvider<Person?>) : ViewModel() {

    val pagedListData = pagedListProvider.provide()

    val adapter = SwapiAdapter()

    fun observePagedList(owner: LifecycleOwner) {
        pagedListData.observe(owner, Observer{ adapter.submitList(it)})
    }
}
