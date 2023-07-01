package com.example.artists.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.artists.R
import com.example.artists.databinding.FragmentTopArtistsBinding
import com.example.artists.model.dataclass.artist.ArtistData
import com.example.artists.view.adapter.AdapterArtists
import com.example.artists.viewmodel.ArtistsViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [TopArtistsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TopArtistsFragment : Fragment(R.layout.fragment_top_artists) {

    private lateinit var binding: FragmentTopArtistsBinding

    private val artistsViewModel: ArtistsViewModel by viewModels()
    private var listArtists: MutableList<ArtistData> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentTopArtistsBinding.bind(requireView())

        artistsViewModel.getDataArtist()

        artistsViewModel.artistsDataModel.observe(viewLifecycleOwner) {
            listArtists = it.artist as MutableList<ArtistData>
            binding.recycler.layoutManager = GridLayoutManager(requireContext(), 2, RecyclerView.VERTICAL, false)
            binding.recycler.adapter = AdapterArtists(listArtists)
        }

        showListArtist()

    }

    private fun showListArtist() {

    }

}