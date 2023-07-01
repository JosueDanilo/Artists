package com.example.artists.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.artists.R
import com.example.artists.databinding.CardsTopArtistBinding
import com.example.artists.model.dataclass.top_tracks.tracks.info_tracks.TrackInfoArtists

class AdapterSong(private val listSong: List<TrackInfoArtists>): RecyclerView.Adapter<AdapterSong.ViewHolder>() {

    private lateinit var binding: CardsTopArtistBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = CardsTopArtistBinding.bind(
            LayoutInflater.from(parent.context).inflate(R.layout.cards_top_artist, parent, false)
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listSong[position])
    }

    override fun getItemCount(): Int {
        return listSong.size
    }

    class ViewHolder(private val binding: CardsTopArtistBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(artistData: TrackInfoArtists) {
            binding.textArtists.text = artistData.name
        }

    }

}