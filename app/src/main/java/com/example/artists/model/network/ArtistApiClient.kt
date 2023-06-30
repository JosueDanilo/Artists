package com.example.artists.model.network

import com.example.artists.model.dataclass.TopArtistsData
import retrofit2.Response
import retrofit2.http.GET

interface ArtistApiClient {

    @GET("?method=geo.gettopartists&country=colombia&api_key=cf2894b9c73a323e24f5c6a9aab1eb85&format=json")
    suspend fun getArtistData(): Response<TopArtistsData>

}