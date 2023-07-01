package com.example.artists.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.artists.R
import com.example.artists.databinding.CardsTopArtistBinding
import com.example.artists.model.dataclass.top_artists.artist.ArtistData
import com.example.artists.view.callback.OnClick

class AdapterArtists(private val listArtists: List<ArtistData>, private val listener: OnClick) :
    RecyclerView.Adapter<AdapterArtists.ViewHolder>() {

    private lateinit var binding: CardsTopArtistBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = CardsTopArtistBinding.bind(
            LayoutInflater.from(parent.context).inflate(R.layout.cards_top_artist, parent, false)
        )
        return ViewHolder(binding, listener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listArtists[position])
    }

    override fun getItemCount(): Int {
        return listArtists.size
    }

    class ViewHolder(private val binding: CardsTopArtistBinding, private val listener: OnClick) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(artistData: ArtistData) {
            binding.textArtists.text = artistData.name

            binding.cardArtist.setOnClickListener {
                listener.onClick(artistData.name)
            }
        }

    }

}