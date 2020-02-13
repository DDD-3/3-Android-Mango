package com.mango.di.module

import com.mango.ui.SplashActivity
import com.mango.ui.detail.DetailActivity
import com.mango.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun bindDetailActivity(): DetailActivity

    @ContributesAndroidInjector
    abstract fun bindSplashActivity(): SplashActivity

}