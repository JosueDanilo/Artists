package com.example.artists.model.repository

import com.example.artists.model.dataclass.top_artists.TopArtistsResponse
import com.example.artists.model.dataclass.top_tracks.TopTracksResponse
import com.example.artists.model.network.ArtistService

class ArtistRepository {

    private val api = ArtistService()

    suspend fun getArtistData(): TopArtistsResponse {
        return api.getArtistData()
    }

    suspend fun getTracksData(nameArtist: String): TopTracksResponse {
        return api.getTracksData(nameArtist)
    }

}