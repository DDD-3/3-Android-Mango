package com.mango.di

import android.content.Context
import com.mango.MangoApplication
import com.mango.di.module.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        ActivityModule::class,
        FragmentModule::class,
        RepositoryModule::class
    ]
)

interface MangoComponent : AndroidInjector<MangoApplication> {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): MangoComponent
    }
}