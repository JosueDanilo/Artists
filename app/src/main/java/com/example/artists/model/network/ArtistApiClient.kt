package com.example.artists.model.network

import com.example.artists.model.dataclass.top_artists.TopArtistsResponse
import com.example.artists.model.dataclass.top_tracks.TopTracksResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ArtistApiClient {

    @GET("/2.0/")
    suspend fun getTopArtists(
        @Query("method") method: String,
        @Query("country") country: String,
        @Query("api_key") apiKey: String,
        @Query("format") format: String,
        @Query("limit") limit: Int
    ): TopArtistsResponse

    @GET("/2.0/")
    suspend fun getTopTracksArtists(
        @Query("method") method: String,
        @Query("artist") artist: String,
        @Query("api_key") apiKey: String,
        @Query("format") format: String,
        @Query("limit") limit: Int
    ): TopTracksResponse

}