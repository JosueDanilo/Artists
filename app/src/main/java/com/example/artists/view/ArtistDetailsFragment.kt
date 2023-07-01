package com.example.artists.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.activityViewModels
import com.example.artists.R
import com.example.artists.databinding.FragmentArtistDetailsBinding
import com.example.artists.model.dataclass.top_artists.artist.ArtistData
import com.example.artists.viewmodel.ArtistsViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [ArtistDetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ArtistDetailsFragment : Fragment(R.layout.fragment_artist_details) {

    private lateinit var binding: FragmentArtistDetailsBinding
    private val artistsViewModel: ArtistsViewModel by activityViewModels()
    private var listArtists: MutableList<ArtistData> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentArtistDetailsBinding.bind(requireView())

        artistsViewModel.getDataPopularArtist()

        artistsViewModel.tracksDataModel.observe(viewLifecycleOwner) {
            binding.text.text = artistsViewModel.nameArtist
        }


    }

}