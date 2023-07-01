package com.example.artists.model.network

import com.example.artists.model.dataclass.TopArtistsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ArtistApiClient {

    @GET("/2.0/")
    suspend fun getTopArtists(
        @Query("method") method: String,
        @Query("country") country: String,
        @Query("api_key") apiKey: String,
        @Query("format") format: String
    ): TopArtistsResponse

}