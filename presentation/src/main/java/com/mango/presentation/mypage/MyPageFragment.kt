package com.mango.presentation.mypage

import androidx.lifecycle.ViewModelProvider
import com.mango.common.createViewModel
import com.mango.presentation.R
import com.mango.presentation.base.BaseFragment
import com.mango.presentation.category.CategoryViewModel
import com.mango.presentation.databinding.FragmentCategoryBinding
import com.mango.presentation.databinding.FragmentMypageBinding
import javax.inject.Inject

class MyPageFragment : BaseFragment<FragmentMypageBinding>(R.layout.fragment_mypage) {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val viewModel: MyPageViewModel by lazy {
        createViewModel(factory, MyPageViewModel::class.java)
    }

    override fun initView() {
        binding.apply {
            viewModel = this@MyPageFragment.viewModel
            lifecycleOwner = this@MyPageFragment
        }
    }

}