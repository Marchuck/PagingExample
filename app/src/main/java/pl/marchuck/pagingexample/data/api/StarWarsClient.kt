package pl.marchuck.pagingexample.data.api

import com.google.gson.Gson
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.experimental.CoroutineCallAdapterFactory
import kotlinx.coroutines.experimental.Deferred
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import pl.marchuck.pagingexample.App
import pl.marchuck.pagingexample.R
import pl.marchuck.pagingexample.data.model.PeopleResponse
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class StarWarsClient(endpoint: String, gson: Gson) : StarWarsApi {


    private val api: StarWarsApi

    init {
        val gsonConverter = GsonConverterFactory.create(gson)

        api = Retrofit.Builder()
                .baseUrl(endpoint)
                .addConverterFactory(gsonConverter)
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .client(buildClient(60))
                .build()
                .create(StarWarsApi::class.java)
    }

    private fun buildClient(timeout: Long): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val builder = OkHttpClient.Builder()
                .readTimeout(timeout, TimeUnit.SECONDS)
                .connectTimeout(timeout, TimeUnit.SECONDS)

        builder.addNetworkInterceptor(loggingInterceptor)

        return builder.build()
    }

    override fun getPeople(page: Int): Deferred<PeopleResponse> = api.getPeople(page);

    companion object {
        fun create() = StarWarsClient(
                endpoint = App.ctx!!.getString(R.string.swapi_endpoint),
                gson = Gson()
        )
    }

}