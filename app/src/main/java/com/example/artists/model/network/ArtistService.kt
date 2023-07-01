package com.example.artists.model.network

import com.example.artists.core.RetrofitHelper
import com.example.artists.core.Utils
import com.example.artists.model.dataclass.top_artists.TopArtistsResponse
import com.example.artists.model.dataclass.top_tracks.TopTracksResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ArtistService {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getArtistData(): TopArtistsResponse {
        return withContext(Dispatchers.IO) {
            retrofit.create(ArtistApiClient::class.java)
                .getTopArtists(Utils.METHOD_ARTIST_TOP, Utils.COUNTRY, Utils.API_KEY, Utils.FORMAT, Utils.LIMIT_ARTIST_TOP)
        }
    }

    suspend fun getTracksData(nameArtist: String): TopTracksResponse {
        return withContext(Dispatchers.IO) {
            retrofit.create(ArtistApiClient::class.java)
                .getTopTracksArtists(Utils.METHOD_TRACKS_TOP, nameArtist, Utils.API_KEY, Utils.FORMAT, Utils.LIMIT_TRACKS_TOP)
        }
    }

}