package com.mango.presentation.main

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mango.common.createViewModel
import com.mango.common.observer
import com.mango.presentation.R
import com.mango.presentation.base.BaseActivity
import com.mango.presentation.databinding.ActivityMainBinding
import com.mango.presentation.detail.DetailActivity
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        observer(viewModel.clickToDetail) {
            startActivity(Intent(this, DetailActivity::class.java))
        }

    }

}