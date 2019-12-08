package com.mango.di.module

import com.mango.di.module.main.CategoryFragmentModule
import com.mango.di.module.main.HomeFragmentModule
import com.mango.di.module.main.MyPageFragmentModule
import com.mango.presentation.category.CategoryFragment
import com.mango.presentation.home.HomeFragment
import com.mango.presentation.mypage.MyPageFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBindingModule {

    @ContributesAndroidInjector(
        modules = [
            ViewModelModule::class,
            HomeFragmentModule::class
        ]
    )
    abstract fun bindHomeFragment(): HomeFragment

    @ContributesAndroidInjector(
        modules = [
            ViewModelModule::class,
            CategoryFragmentModule::class
        ]
    )
    abstract fun bindCategoryFragment(): CategoryFragment

    @ContributesAndroidInjector(
        modules = [
            ViewModelModule::class,
            MyPageFragmentModule::class
        ]
    )
    abstract fun bindMyPageFragment(): MyPageFragment

}