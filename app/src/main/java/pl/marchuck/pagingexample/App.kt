package pl.marchuck.pagingexample

import android.app.Application
import android.arch.paging.DataSource
import android.content.Context
import pl.marchuck.pagingexample.data.SwapiPeopleDataSource
import pl.marchuck.pagingexample.data.model.Person

class App : Application() {

    lateinit var factory: DataSource.Factory<Int, Person?>

    companion object {
        var ctx: Context? = null

        fun get() = ctx as App
    }

    override fun onCreate() {
        super.onCreate()
        ctx = this

        factory = SwapiPeopleDataSource.factory()

    }


}