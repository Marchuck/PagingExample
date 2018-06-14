package pl.marchuck.pagingexample.pagination.adapter

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import pl.marchuck.pagingexample.data.model.Person

class SwapiPersonViewModel(item: Person?) : ViewModel() {
    val name = ObservableField(item?.name)
    val gender = ObservableField(item?.gender)
}