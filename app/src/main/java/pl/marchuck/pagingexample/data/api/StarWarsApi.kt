package pl.marchuck.pagingexample.data.api

import kotlinx.coroutines.experimental.Deferred
import pl.marchuck.pagingexample.data.model.PeopleResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface StarWarsApi {

    @GET("people/")
    fun getPeople(@Query("page") page: Int): Deferred<PeopleResponse>
}