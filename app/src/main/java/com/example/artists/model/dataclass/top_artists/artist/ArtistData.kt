package com.example.artists.model.dataclass.top_artists.artist

import com.example.artists.model.dataclass.top_artists.artist.image.ImageArtistData

data class ArtistData(
    val name: String,
    val listeners: String,
    val mbid: String,
    val url: String,
    val streamable: String,
    val image: List<ImageArtistData>
)
