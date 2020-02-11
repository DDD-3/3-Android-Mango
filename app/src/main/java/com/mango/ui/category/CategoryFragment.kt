package com.mango.ui.category

import androidx.lifecycle.ViewModelProvider
import com.mango.R
import com.mango.base.BaseFragment
import com.mango.common.createViewModel
import com.mango.databinding.FragmentCategoryBinding
import javax.inject.Inject

class CategoryFragment : BaseFragment<FragmentCategoryBinding>(R.layout.fragment_category){

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
    }
}