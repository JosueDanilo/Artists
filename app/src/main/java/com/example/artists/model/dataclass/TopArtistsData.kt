package com.example.artists.model.dataclass

import com.example.artists.model.dataclass.artist.ArtistData

data class TopArtistsData(
    private val artist: List<ArtistData>
)
