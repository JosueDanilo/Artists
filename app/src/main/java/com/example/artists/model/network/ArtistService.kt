package com.example.artists.model.network

import com.example.artists.core.RetrofitHelper
import com.example.artists.model.dataclass.TopArtistsData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ArtistService {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getArtistData(): TopArtistsData? {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(ArtistApiClient::class.java).getArtistData()
            response.body()
        }
    }
}