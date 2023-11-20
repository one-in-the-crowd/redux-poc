package com.example.reduxpoc

import android.app.Application
import com.example.reduxpoc.di.appModule
import org.koin.core.context.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        initDi()
    }

    private fun initDi() {
        startKoin {
            modules(appModule)
        }
    }
}