package com.example.artists.model.dataclass.artist

import com.example.artists.model.dataclass.artist.image.ImageArtistData

data class ArtistData(
    private val name: String,
    private val listeners: String,
    private val mbid: String,
    private val url: String,
    private val streamable: String,
    private val image: List<ImageArtistData>
)
