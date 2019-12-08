package com.mango.di.module

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import com.mango.di.ViewModelFactory

@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(
        factory: ViewModelFactory
    ): ViewModelProvider.Factory
}
