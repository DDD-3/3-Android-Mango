package com.mango.ui.main

import com.mango.R
import com.mango.base.BaseActivity
import com.mango.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private val viewModel by viewModel<MainViewModel>()

    override fun initView() {
        binding.viewModel = viewModel
    }

}