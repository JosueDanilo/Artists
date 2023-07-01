package com.example.artists.model.dataclass.top_tracks.tracks.info_tracks

import com.example.artists.model.dataclass.top_artists.artist.image.ImageArtistData
import com.example.artists.model.dataclass.top_tracks.tracks.info_tracks.artists.ArtistsData
import com.google.gson.annotations.SerializedName

data class TrackInfoArtists(
    val name: String,
    val playcount: String,
    val listeners: String,
    val mbid: String,
    val url: String,
    val streamable: String,
    val artist: ArtistsData,
    val image: List<ImageArtistData>,
    @SerializedName("@attr")
    val attr: AttrArtists,
    )