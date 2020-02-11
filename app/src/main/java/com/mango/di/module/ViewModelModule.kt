package com.mango.di.module

import androidx.lifecycle.ViewModel
import com.mango.di.qualifier.ViewModelKey
import com.mango.ui.category.CategoryViewModel
import com.mango.ui.detail.DetailViewModel
import com.mango.ui.home.HomeViewModel
import com.mango.ui.main.MainViewModel
import com.mango.ui.mypage.MyPageViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MyPageViewModel::class)
    abstract fun bindMyPageViewModel(viewModel: MyPageViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(viewModel: HomeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CategoryViewModel::class)
    abstract fun bindCategoryViewModel(viewModel: CategoryViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DetailViewModel::class)
    abstract fun bindDetailViewModel(viewModel: DetailViewModel): ViewModel

}