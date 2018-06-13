package pl.marchuck.pagingexample.pagination.adapter

import android.support.v7.widget.RecyclerView
import pl.marchuck.pagingexample.BR
import pl.marchuck.pagingexample.data.model.ResultsItem
import pl.marchuck.pagingexample.databinding.ItemSwapiPersonBinding

class SwapiPersonViewHolder(private val binding: ItemSwapiPersonBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: ResultsItem?) {
        binding.setVariable(BR.personModel, SwapiPersonViewModel(item))
        binding.executePendingBindings()
    }

}