package com.mango.ui.main

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.mango.common.createViewModel
import com.mango.R
import com.mango.base.BaseActivity
import com.mango.ui.category.CategoryFragment
import com.mango.databinding.ActivityMainBinding
import com.mango.ui.home.HomeFragment
import com.mango.ui.mypage.MyPageFragment
import com.mango.util.consume
import com.mango.util.inTransaction
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

        binding.bnvMain.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home -> consume { replaceFragment(HomeFragment()) }
                R.id.category -> consume { replaceFragment(CategoryFragment()) }
                R.id.my_page -> consume { replaceFragment(MyPageFragment()) }
                else -> throw IllegalStateException("Invalid Id")
            }
        }
        binding.bnvMain.selectedItemId = R.id.home

    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.inTransaction {
            replace(R.id.fl_main, fragment)
        }
    }
}