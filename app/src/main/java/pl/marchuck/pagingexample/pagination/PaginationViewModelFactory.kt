package pl.marchuck.pagingexample.pagination

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import pl.marchuck.pagingexample.data.PagedListProvider
import pl.marchuck.pagingexample.data.model.ResultsItem

@Suppress("UNCHECKED_CAST")
class PaginationViewModelFactory(private val pagedListProvider: PagedListProvider<ResultsItem?>) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PaginationViewModel(pagedListProvider) as T
    }
}