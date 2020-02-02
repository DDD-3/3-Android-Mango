package com.mango.presentation.main

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.mango.common.createViewModel
import com.mango.common.observer
import com.mango.presentation.R
import com.mango.presentation.base.BaseActivity
import com.mango.presentation.category.CategoryFragment
import com.mango.presentation.databinding.ActivityMainBinding
import com.mango.presentation.detail.DetailActivity
import com.mango.presentation.home.HomeFragment
import com.mango.presentation.mypage.MyPageFragment
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
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fl_main, HomeFragment()).commitAllowingStateLoss()

        binding.bnvMain.apply {
            setOnNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.home -> {
                        transaction.replace(R.id.fl_main, HomeFragment()).commitAllowingStateLoss()
                        true
                    }
                    R.id.cateogry -> {
                        transaction.replace(R.id.fl_main, CategoryFragment())
                            .commitAllowingStateLoss()
                        true
                    }
                    else -> {
                        transaction.replace(R.id.fl_main, MyPageFragment())
                            .commitAllowingStateLoss()
                        true
                    }
                }
            }

        }
    }

}