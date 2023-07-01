package com.example.artists.model.network

import com.example.artists.core.RetrofitHelper
import com.example.artists.core.Utils
import com.example.artists.model.dataclass.TopArtistsResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ArtistService {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getArtistData(): TopArtistsResponse {

        val method = "geo.gettopartists"

        return withContext(Dispatchers.IO) {
            retrofit.create(ArtistApiClient::class.java)
                .getTopArtists(method, Utils.COUNTRY, Utils.API_KEY, Utils.FORMAT)
        }
    }
}