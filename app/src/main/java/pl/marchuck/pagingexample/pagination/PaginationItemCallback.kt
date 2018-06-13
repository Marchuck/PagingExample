package pl.marchuck.pagingexample.pagination

import android.support.v7.util.DiffUtil
import pl.marchuck.pagingexample.data.model.ResultsItem

object PaginationItemCallback : DiffUtil.ItemCallback<ResultsItem?>() {

    override fun areItemsTheSame(oldItem: ResultsItem?, newItem: ResultsItem?): Boolean {
        if (oldItem == null || newItem == null) return false
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: ResultsItem?, newItem: ResultsItem?): Boolean {
        if (oldItem == null || newItem == null) return false
        return oldItem.name == newItem.name
    }
}