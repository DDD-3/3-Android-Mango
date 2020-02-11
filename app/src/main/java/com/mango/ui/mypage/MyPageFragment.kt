package com.mango.ui.mypage

import androidx.lifecycle.ViewModelProvider
import com.mango.R
import com.mango.base.BaseFragment
import com.mango.common.createViewModel
import com.mango.databinding.FragmentMypageBinding
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
            lifecycleOwner = viewLifecycleOwner
        }
    }

}