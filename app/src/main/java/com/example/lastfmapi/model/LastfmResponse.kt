package com.example.lastfmapi.model

import com.google.gson.annotations.SerializedName

class LastfmResponse (
    @SerializedName("Artist") val artist: String,
    @SerializedName("Album")val album: String
)