package com.mango.di.module

import com.mango.presentation.category.CategoryFragment
import com.mango.presentation.home.HomeFragment
import com.mango.presentation.mypage.MyPageFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun bindHomeFragment(): HomeFragment

    @ContributesAndroidInjector
    abstract fun bindCategoryFragment(): CategoryFragment

    @ContributesAndroidInjector
    abstract fun bindMyPageFragment(): MyPageFragment

}