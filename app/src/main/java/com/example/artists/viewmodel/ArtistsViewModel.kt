package com.example.artists.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.artists.model.dataclass.top_artists.TopArtistsData
import com.example.artists.model.dataclass.top_tracks.TopTracksResponse
import com.example.artists.model.repository.ArtistRepository
import kotlinx.coroutines.launch

class ArtistsViewModel : ViewModel() {

    // obtener los artistas mas populares
    private val _artistModel = MutableLiveData<TopArtistsData>()
    val artistsDataModel: LiveData<TopArtistsData> get() = _artistModel

    // obtener las canciones mas populares por artista
    private val _tracksModel = MutableLiveData<TopTracksResponse>()
    val tracksDataModel: LiveData<TopTracksResponse> get() = _tracksModel

    var nameArtist: String = ""

    private val artistsRepository = ArtistRepository()

    fun getDataArtist() {
        viewModelScope.launch {
            val result = artistsRepository.getArtistData()
            _artistModel.postValue(result.topartists)
        }
    }

    fun getDataPopularArtist() {
        viewModelScope.launch {
            val result = artistsRepository.getTracksData(nameArtist)
            _tracksModel.postValue(result)
        }
    }

}