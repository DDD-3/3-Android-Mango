package com.mango

import android.app.Application
import com.mango.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.logger.AndroidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MangoApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MangoApplication)

            modules(appModules)

            logger(AndroidLogger(Level.DEBUG))
        }
    }
}