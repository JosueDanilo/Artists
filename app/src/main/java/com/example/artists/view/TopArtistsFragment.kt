package com.example.artists.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.artists.R
import com.example.artists.databinding.FragmentTopArtistsBinding
import com.example.artists.model.dataclass.top_artists.artist.ArtistData
import com.example.artists.view.adapter.AdapterArtists
import com.example.artists.view.callback.OnClick
import com.example.artists.viewmodel.ArtistsViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [TopArtistsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TopArtistsFragment : Fragment(R.layout.fragment_top_artists), OnClick {

    private lateinit var binding: FragmentTopArtistsBinding

    private val artistsViewModel: ArtistsViewModel by activityViewModels()
    private val listArtists: MutableList<ArtistData> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentTopArtistsBinding.bind(requireView())

        artistsViewModel.getDataArtist()

        artistsViewModel.artistsDataModel.observe(viewLifecycleOwner) {
            listArtists.clear()
            listArtists.addAll(it.artist)
            binding.recycler.layoutManager =
                GridLayoutManager(requireContext(), 2, RecyclerView.VERTICAL, false)
            binding.recycler.adapter = AdapterArtists(listArtists, this)
        }

    }

    override fun onClick(nameArtist: String) {
        artistsViewModel.nameArtist = nameArtist
        val action =
            TopArtistsFragmentDirections.actionTopArtistsFragmentToArtistDetailsFragment(nameArtist)
        findNavController().navigate(action)
    }

}