package pl.marchuck.pagingexample.pagination

import android.support.v7.util.DiffUtil
import pl.marchuck.pagingexample.data.model.Person

object PaginationItemCallback : DiffUtil.ItemCallback<Person?>() {

    override fun areItemsTheSame(oldItem: Person?, newItem: Person?): Boolean {
        if (oldItem == null || newItem == null) return false
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Person?, newItem: Person?): Boolean {
        if (oldItem == null || newItem == null) return false
        return oldItem.name == newItem.name
    }
}