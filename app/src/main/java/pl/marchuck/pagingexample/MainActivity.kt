package pl.marchuck.pagingexample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import pl.marchuck.pagingexample.pagination.PaginationFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, PaginationFragment.newInstance())
                    .commitNow()
        }
    }

}
