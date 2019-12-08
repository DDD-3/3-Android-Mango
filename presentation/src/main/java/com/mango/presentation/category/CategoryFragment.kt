package com.mango.presentation.category

import androidx.lifecycle.ViewModelProvider
import com.mango.common.createViewModel
import com.mango.presentation.R
import com.mango.presentation.base.BaseFragment
import com.mango.presentation.databinding.FragmentCategoryBinding
import com.mango.presentation.databinding.FragmentHomeBinding
import com.mango.presentation.home.HomeViewModel
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
            lifecycleOwner = this@CategoryFragment
        }
    }

}