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
    val tracksModel = MutableLiveData<TopTracksResponse?>()

    // Notifica progressBar
    private val _loadingModel = MutableLiveData<Boolean>()
    val loadingModel: LiveData<Boolean> get() = _loadingModel

    // Notifica errores
    private val _errorModel = MutableLiveData<String>()
    val errorModel: LiveData<String> get() = _errorModel

    private val artistsRepository = ArtistRepository()

    /**
     *
     * Metodo encargado realizar la busqueda de los artistas mas populares de colombia.
     *
     */
    fun getDataArtist() {
        _loadingModel.postValue(true)
        viewModelScope.launch {
            try {
                val result = artistsRepository.getArtistData()
                _artistModel.postValue(result.topartists)
            } catch (e: Exception) {
                _errorModel.postValue("Error al obtener los Artistas")
            }
            _loadingModel.postValue(false)
        }
    }

    /**
     *
     * Metodo encargado realizar la busqueda de las canciones mas populares de los artistas.
     * @param nameArtist Nombre del artista
     */
    fun getDataPopularArtist(nameArtist: String) {
        _loadingModel.postValue(true)
        viewModelScope.launch {
            try {
                val result = artistsRepository.getTracksData(nameArtist)
                tracksModel.postValue(result)
            } catch (e: Exception) {
                _errorModel.postValue("Error al obtener las canciones populares")
            }
            _loadingModel.postValue(false)
        }
    }

}