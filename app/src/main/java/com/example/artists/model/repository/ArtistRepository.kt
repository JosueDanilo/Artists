package com.example.artists.model.repository

import com.example.artists.model.dataclass.TopArtistsData
import com.example.artists.model.network.ArtistService

class ArtistRepository {

    private val api = ArtistService()

    suspend fun getArtistData(): TopArtistsData? {
        return api.getArtistData()
    }

}