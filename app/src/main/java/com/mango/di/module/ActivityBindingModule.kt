package com.mango.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import com.mango.di.module.main.MainActivityModule
import com.mango.presentation.base.main.MainActivity

@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector(
        modules = [
            ViewModelModule::class,
            MainActivityModule::class
        ]
    )
    abstract fun bindMainActivity(): MainActivity

}