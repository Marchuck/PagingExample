package pl.marchuck.pagingexample.pagination.adapter

import android.support.v7.widget.RecyclerView
import pl.marchuck.pagingexample.data.model.Person
import pl.marchuck.pagingexample.databinding.ItemSwapiPersonBinding

class SwapiPersonViewHolder(private val binding: ItemSwapiPersonBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Person?) {
        binding.personModel = SwapiPersonViewModel(item)
        binding.executePendingBindings()
    }

}