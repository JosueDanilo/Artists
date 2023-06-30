package com.example.artists.model.dataclass.artist.image

import com.google.gson.annotations.SerializedName

data class ImageArtistData(
    @SerializedName("#text")
    private val text: String,
    private val size: String
)