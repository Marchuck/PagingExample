package pl.marchuck.pagingexample.data

import android.arch.paging.DataSource
import android.arch.paging.PageKeyedDataSource
import kotlinx.coroutines.experimental.async
import pl.marchuck.pagingexample.data.model.Person

class SwapiPeopleDataSource(val useCase: GetPeopleUseCase = GetPeopleUseCase.create()) : PageKeyedDataSource<Int, Person?>() {

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, Person?>) {
        async {
            val items = useCase.execute(page = 1).await()
            callback.onResult(items.orEmpty(), null, 2)
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Person?>) {
        async {
            val items = useCase.execute(page = params.key).await()
            callback.onResult(items.orEmpty(), calculateNext(params.key))
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Person?>) {
        async {
            val items = useCase.execute(page = params.key).await()
            callback.onResult(items.orEmpty(), calculatePrevious(params.key))
        }
    }

    private fun calculatePrevious(key: Int?) = key?.dec() ?: 1

    private fun calculateNext(key: Int?) = key?.inc() ?: 1

    companion object {

        fun factory() = object : DataSource.Factory<Int, Person?>() {
            override fun create() = SwapiPeopleDataSource()
        }
    }
}