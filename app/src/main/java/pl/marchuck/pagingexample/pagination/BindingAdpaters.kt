package pl.marchuck.pagingexample.pagination

import android.databinding.BindingAdapter
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.ImageView
import pl.marchuck.pagingexample.PersonMapper


@BindingAdapter("android:adapterSetup")
fun setupRecyclerViewAdapter(view: RecyclerView, viewModel: PaginationViewModel) {

    view.layoutManager = LinearLayoutManager(view.context)
    view.adapter = viewModel.adapter

}

@BindingAdapter("android:genderImage")
fun setupGenderImage(view: ImageView, gender: String) {

    view.setImageResource(
            PersonMapper.getGenderDrawable(gender)
    )

}