package com.mango.presentation.home

import androidx.lifecycle.ViewModelProvider
import com.mango.common.createViewModel
import com.mango.presentation.R
import com.mango.presentation.base.BaseFragment
import com.mango.presentation.databinding.FragmentHomeBinding
import javax.inject.Inject

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val viewModel: HomeViewModel by lazy {
        createViewModel(factory, HomeViewModel::class.java)
    }

    override fun initView() {
        binding.apply {
            viewModel = this@HomeFragment.viewModel
            lifecycleOwner = this@HomeFragment
        }
    }

}