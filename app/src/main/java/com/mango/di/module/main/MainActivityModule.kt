package com.mango.di.module.main

import androidx.lifecycle.ViewModel
import com.mango.presentation.main.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import com.mango.di.module.UseCaseModule
import com.mango.di.qualifier.ViewModelKey

//include test
@Module
abstract class MainActivityModule {
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindViewModel(viewModel: MainViewModel): ViewModel
}