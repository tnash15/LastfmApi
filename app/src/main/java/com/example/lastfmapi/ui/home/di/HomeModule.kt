package com.example.lastfmapi.ui.home.di

import com.example.lastfmapi.net.LastFmService
import com.example.lastfmapi.ui.home.HomeContract
import com.example.lastfmapi.ui.home.HomePresenter
import dagger.Module
import dagger.Provides


@Module
class HomeModule(private val view: HomeContract.View) {

    @Provides
    @HomeScope
    fun providesHomePresenter(lastFmService: LastFmService): HomeContract.Presenter{
        return HomePresenter(lastFmService, view)
    }
}
