package com.mango.di.module

import com.mango.di.module.main.MainActivityModule
import com.mango.presentation.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

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