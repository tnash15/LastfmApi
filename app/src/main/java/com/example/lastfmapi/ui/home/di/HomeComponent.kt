package com.example.lastfmapi.ui.home.di

import com.example.lastfmapi.di.AppComponent
import com.example.lastfmapi.ui.home.MainActivity
import dagger.Component

@Component(modules = [HomeModule::class], dependencies = [AppComponent::class])
@HomeScope
interface HomeComponent {
    fun inject(mainActivity: MainActivity)
}