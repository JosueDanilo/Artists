package com.example.artists.core

import android.content.Context
import android.widget.Toast

class Utils {

    companion object {

        const val BASE_URL = "http://ws.audioscrobbler.com/2.0/"
        const val API_KEY = "cf2894b9c73a323e24f5c6a9aab1eb85"
        const val FORMAT = "json"
        const val METHOD_ARTIST_TOP = "geo.gettopartists"
        const val METHOD_TRACKS_TOP = "artist.gettoptracks"
        const val COUNTRY = "colombia"
        const val LIMIT_ARTIST_TOP = 10
        const val LIMIT_TRACKS_TOP = 5

        fun Context.showMessage(message: String, duration: Int = Toast.LENGTH_SHORT) {
            Toast.makeText(this, message, duration).show()
        }

    }

}