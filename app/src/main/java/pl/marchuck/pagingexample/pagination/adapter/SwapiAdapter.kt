package pl.marchuck.pagingexample.pagination.adapter

import android.arch.paging.PagedListAdapter
import android.databinding.DataBindingUtil
import android.support.v7.util.DiffUtil
import android.view.LayoutInflater
import android.view.ViewGroup
import pl.marchuck.pagingexample.R
import pl.marchuck.pagingexample.data.model.ResultsItem
import pl.marchuck.pagingexample.databinding.ItemSwapiPersonBinding
import pl.marchuck.pagingexample.pagination.PaginationItemCallback

class SwapiAdapter(diffCallback: DiffUtil.ItemCallback<ResultsItem?> = PaginationItemCallback)
    : PagedListAdapter<ResultsItem, SwapiPersonViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SwapiPersonViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val binding = DataBindingUtil.inflate<ItemSwapiPersonBinding>(
                inflater, R.layout.item_swapi_person, parent, false)
        return SwapiPersonViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SwapiPersonViewHolder, position: Int) {
        val item = getItem(position)

        holder.bind(item)
    }
}