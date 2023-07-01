package com.example.artists.model.network

import com.example.artists.core.RetrofitHelper
import com.example.artists.model.dataclass.TopArtistsResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ArtistService {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getArtistData(): TopArtistsResponse {

        val method = "geo.gettopartists"
        val country = "colombia"
        val apiKey = "cf2894b9c73a323e24f5c6a9aab1eb85"
        val format = "json"

        return withContext(Dispatchers.IO) {
            retrofit.create(ArtistApiClient::class.java).getTopArtists(method, country, apiKey, format)
        }
    }
}