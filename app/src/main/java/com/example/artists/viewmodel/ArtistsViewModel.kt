package com.example.artists.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.artists.model.dataclass.TopArtistsData
import com.example.artists.model.dataclass.artist.ArtistData
import com.example.artists.model.repository.ArtistRepository
import kotlinx.coroutines.launch

class ArtistsViewModel : ViewModel() {

    private val _artistModel = MutableLiveData<TopArtistsData>()
    val artistsDataModel: LiveData<TopArtistsData> get() = _artistModel

    private val artistsRepository = ArtistRepository()

    fun getDataArtist() {
        viewModelScope.launch {
            val result = artistsRepository.getArtistData()
            if (result != null)
                _artistModel.postValue(result.topartists)
        }
    }

}