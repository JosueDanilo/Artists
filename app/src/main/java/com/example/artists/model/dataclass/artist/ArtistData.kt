package com.example.artists.model.dataclass.artist

import com.example.artists.model.dataclass.artist.image.ImageArtistData

data class ArtistData(
    val name: String,
    val listeners: String,
    val mbid: String,
    val url: String,
    val streamable: String,
    val image: List<ImageArtistData>
)
