package com.example.lastfmapi.ui.home

import com.example.lastfmapi.model.LastfmResponse

class HomeContract {

    interface View {
        fun showLastFmInfo(results:List<LastfmResponse>)
        fun showError(message: String)
    }

    interface Presenter {
        fun getInfo(artist: String, album: String)
    }
}
