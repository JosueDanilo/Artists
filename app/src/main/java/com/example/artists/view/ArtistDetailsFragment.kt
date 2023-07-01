package com.example.artists.view

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.artists.R
import com.example.artists.core.Utils.Companion.showMessage
import com.example.artists.databinding.FragmentArtistDetailsBinding
import com.example.artists.model.dataclass.top_tracks.tracks.info_tracks.TrackInfoArtists
import com.example.artists.view.adapter.AdapterArtists
import com.example.artists.view.adapter.AdapterSong
import com.example.artists.viewmodel.ArtistsViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [ArtistDetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ArtistDetailsFragment : Fragment(R.layout.fragment_artist_details) {

    private lateinit var binding: FragmentArtistDetailsBinding
    private val artistsViewModel: ArtistsViewModel by viewModels()
    private val listSongs: MutableList<TrackInfoArtists> = mutableListOf()

    private val args: ArtistDetailsFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentArtistDetailsBinding.bind(requireView())

        val nameArtists = args.nameArtist

        artistsViewModel.loadingModel.observe(viewLifecycleOwner) {
            if (it) {
                binding.progressBar.visibility = View.VISIBLE
            } else {
                binding.progressBar.visibility = View.GONE
            }

        }

        artistsViewModel.getDataPopularArtist(nameArtists)

        artistsViewModel.tracksModel.observe(viewLifecycleOwner) {
            binding.popularSong.text = "$nameArtists Popular Songs"
            listSongs.clear()
            it?.toptracks?.let { it1 -> listSongs.addAll(it1.track) }
            binding.recycler.layoutManager =
                GridLayoutManager(requireContext(), 2, RecyclerView.VERTICAL, false)
            binding.recycler.adapter = AdapterSong(listSongs)
        }

        artistsViewModel.errorModel.observe(viewLifecycleOwner) {
            requireContext().showMessage(it)
        }

    }

}