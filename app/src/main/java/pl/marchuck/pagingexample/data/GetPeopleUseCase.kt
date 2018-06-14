package pl.marchuck.pagingexample.data

import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.async
import pl.marchuck.pagingexample.data.api.StarWarsApi
import pl.marchuck.pagingexample.data.api.StarWarsClient
import pl.marchuck.pagingexample.data.model.PeopleResponse
import pl.marchuck.pagingexample.data.model.Person

class GetPeopleUseCase(private val api: StarWarsApi) {

    fun execute(page: Int): Deferred<List<Person?>?> {
        return async { transform(page) }
    }

    private suspend fun transform(page: Int): List<Person?> {
        val response = api.getPeople(page).await()

        return response.results ?: emptyList()
    }

    companion object {
        fun create() = GetPeopleUseCase(api = StarWarsClient.create())
    }
}