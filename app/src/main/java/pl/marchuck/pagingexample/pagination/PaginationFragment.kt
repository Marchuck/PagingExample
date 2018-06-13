package pl.marchuck.pagingexample.pagination

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import pl.marchuck.pagingexample.App
import pl.marchuck.pagingexample.R
import pl.marchuck.pagingexample.data.SwapiPeoplePagedListProvider
import pl.marchuck.pagingexample.databinding.PaginationFragmentBinding


class PaginationFragment : Fragment() {

    companion object {
        fun newInstance() = PaginationFragment()
    }

    lateinit var viewModel: PaginationViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val binding = DataBindingUtil.inflate<PaginationFragmentBinding>(inflater,
                R.layout.pagination_fragment, container, false)

        //normally you would use DI framework to inject viewModel
        viewModel = provideViewModel()

        binding.viewModel = viewModel

        viewModel.observePagedList(this)

        return binding.root
    }

    private fun provideViewModel() = PaginationViewModelFactory(
            pagedListProvider = SwapiPeoplePagedListProvider(
                    factory = App.get().factory))
            .create(PaginationViewModel::class.java)

}
