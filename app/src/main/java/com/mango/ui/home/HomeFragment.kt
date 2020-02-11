package com.mango.ui.home

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import com.mango.R
import com.mango.base.BaseFragment
import com.mango.common.createViewModel
import com.mango.common.showToast
import com.mango.databinding.FragmentHomeBinding
import com.mango.ui.detail.DetailActivity
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

        binding.rvHome.apply {
            addItemDecoration(DividerItemDecoration(context, LinearLayout.VERTICAL))
            adapter = HomeAdapter(this@HomeFragment.viewModel, this@HomeFragment)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.error.observe(viewLifecycleOwner, Observer {
            requireContext().showToast("일시적으로 네트워크에 문제가 생겼습니다.\n 잠시 후 다시 시도해주세요.")
        })

        viewModel.clickToDetail.observe(viewLifecycleOwner, Observer {
            DetailActivity.starterDetailById(requireContext(), it.id)
        })
    }

}