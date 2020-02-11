package com.mango.ui.home

import androidx.lifecycle.ViewModelProvider
import com.mango.common.createViewModel
import com.mango.common.observer
import com.mango.common.showToast
import com.mango.R
import com.mango.base.BaseFragment
import com.mango.databinding.FragmentHomeBinding
import com.mango.ui.detail.DetailActivity
import com.orhanobut.logger.Logger
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
            lifecycleOwner = viewLifecycleOwner
        }

        observer(viewModel.error) {
            requireContext().showToast("일시적으로 네트워크에 문제가 생겼습니다.\n 잠시 후 다시 시도해주세요.")
            Logger.e(it.message!!)
        }

        observer(viewModel.clickToDetail) {
            DetailActivity.starterDetailById(requireContext(), it.id)
        }
    }

}