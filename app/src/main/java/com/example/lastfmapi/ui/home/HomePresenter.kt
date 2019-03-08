package com.example.lastfmapi.ui.home

import com.example.lastfmapi.net.LastFmService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


class HomePresenter (

    private val lastFmService: LastFmService,
    private val view: HomeContract.View) : HomeContract.Presenter {


    private val compositeDisposable = CompositeDisposable()

    override fun getInfo(artist: String, album: String) {
        compositeDisposable.add(lastFmService.getInfo(artist, album)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({view.showLastFmInfo(it)}, { throwable -> view.showError(throwable.message!!)}))

    }
}
