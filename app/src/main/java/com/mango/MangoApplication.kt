package com.mango

import com.mango.di.DaggerMangoComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class MangoApplication : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerMangoComponent.factory().create(applicationContext)
    }
}