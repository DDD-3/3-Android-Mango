package com.mango.ui.category

import androidx.databinding.BindingAdapter
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mango.R
import com.mango.base.BaseFragment
import com.mango.common.createViewModel
import com.mango.databinding.FragmentCategoryBinding
import com.mango.model.Category
import com.mango.util.GridSpacingItemDecoration
import com.mango.util.dp2px
import javax.inject.Inject

class CategoryFragment : BaseFragment<FragmentCategoryBinding>(R.layout.fragment_category) {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val viewModel: CategoryViewModel by lazy {
        createViewModel(factory, CategoryViewModel::class.java)
    }

    override fun initView() {
        binding.apply {
            viewModel = this@CategoryFragment.viewModel
            lifecycleOwner = viewLifecycleOwner
        }

        binding.categoryRecyclerView.apply {
            setHasFixedSize(true)
            adapter = CategoryAdapter(viewLifecycleOwner)
            addItemDecoration(GridSpacingItemDecoration(2, dp2px(requireContext(), 22f), true))
        }
    }
}

@BindingAdapter("submitCategory")
fun submitCategory(recyclerView: RecyclerView, items: List<Category>?) {
    items?.let {
        (recyclerView.adapter as CategoryAdapter).submitList(it)
    }
}