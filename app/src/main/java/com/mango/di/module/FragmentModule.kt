package com.mango.di.module

import com.mango.ui.category.CategoryFragment
import com.mango.ui.home.HomeFragment
import com.mango.ui.message.MessageFragment
import com.mango.ui.mypage.MyPageFragment
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

    @ContributesAndroidInjector
    abstract fun bindMessageFragment(): MessageFragment

}