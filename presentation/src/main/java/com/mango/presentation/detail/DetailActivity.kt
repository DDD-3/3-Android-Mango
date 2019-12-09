package com.mango.presentation.detail

import androidx.lifecycle.ViewModelProvider
import com.mango.common.createViewModel
import com.mango.presentation.R
import com.mango.presentation.base.BaseActivity
import com.mango.presentation.databinding.ActivityDetailBinding
import javax.inject.Inject

class DetailActivity : BaseActivity<ActivityDetailBinding>(R.layout.activity_detail) {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val vieModel: DetailViewModel by lazy {
        createViewModel(factory, DetailViewModel::class.java)
    }

    override fun initView() {
        binding.apply {
            viewModel = this@DetailActivity.vieModel
            lifecycleOwner = this@DetailActivity
        }
    }


}