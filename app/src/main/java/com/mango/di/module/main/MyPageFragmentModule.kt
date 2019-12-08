package com.mango.di.module.main

import androidx.lifecycle.ViewModel
import com.mango.di.qualifier.ViewModelKey
import com.mango.presentation.category.CategoryViewModel
import com.mango.presentation.home.HomeViewModel
import com.mango.presentation.mypage.MyPageViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MyPageFragmentModule {
    @Binds
    @IntoMap
    @ViewModelKey(MyPageViewModel::class)
    abstract fun bindViewModel(viewModel: MyPageViewModel): ViewModel
}