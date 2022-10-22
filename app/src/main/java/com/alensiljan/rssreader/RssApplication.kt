package com.alensiljan.rssreader

import android.app.Application
import com.alensiljan.rssreader.di.repositoriesModule
import com.alensiljan.rssreader.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

private val modules = listOf(
    repositoryModule,
    repositoriesModule
)

class RssApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@RssApplication)
            koin.loadModules(modules)
        }
    }
}