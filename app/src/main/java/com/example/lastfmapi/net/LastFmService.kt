package com.example.lastfmapi.net

import com.example.lastfmapi.model.LastfmResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface LastFmService {

    @GET(" /2.0/?method=artist.search&artist=cher&api_key=3b051a449b5079a580e4f40440d61fa9&format=json")
    fun searchArtist(@Query("artist") artist: String): Observable<LastfmResponse>

    @GET("/2.0/?method=album.search&album=believe&api_key=3b051a449b5079a580e4f40440d61fa9&format=json")
    fun searchAlbum(@Query("album") album: String): Observable<LastfmResponse>

}