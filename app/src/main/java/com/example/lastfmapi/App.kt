package com.example.lastfmapi

import android.app.Application
import com.example.lastfmapi.di.AppComponent
import com.example.lastfmapi.di.DaggerAppComponent

class App : Application() {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .build()
    }

    fun getAppComponent() = appComponent
}