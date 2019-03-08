package com.example.lastfmapi.di

import com.example.lastfmapi.net.LastFmService
import dagger.Component
import javax.inject.Singleton

@Component(modules = [NetworkModule::class])
@Singleton

interface AppComponent {
    fun lastFmService(): LastFmService
}