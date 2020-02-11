package com.mango.ui.main

import androidx.lifecycle.ViewModelProvider
import com.mango.common.createViewModel
import com.mango.R
import com.mango.base.BaseActivity
import com.mango.ui.category.CategoryFragment
import com.mango.databinding.ActivityMainBinding
import com.mango.ui.home.HomeFragment
import com.mango.ui.mypage.MyPageFragment
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