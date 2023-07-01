package com.example.artists.model.repository

import com.example.artists.model.dataclass.TopArtistsResponse
import com.example.artists.model.network.ArtistService

class ArtistRepository {

    private val api = ArtistService()

    suspend fun getArtistData(): TopArtistsResponse? {
        return api.getArtistData()
    }

}