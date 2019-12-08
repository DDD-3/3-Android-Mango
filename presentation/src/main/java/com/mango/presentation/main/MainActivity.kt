package com.mango.presentation.main

import androidx.lifecycle.ViewModelProvider
import com.mango.common.createViewModel
import com.mango.presentation.R
import com.mango.presentation.base.BaseActivity
import com.mango.presentation.databinding.ActivityMainBinding
import javax.inject.Inject


class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val viewModel: MainViewModel by lazy {
        createViewModel(factory, MainViewModel::class.java)
    }

    override fun initView() {
        binding.apply {
            mainViewModel = viewModel
            lifecycleOwner = this@MainActivity
        }
    }

}