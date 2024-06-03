package ru.kpfu.itis.bagaviev.feed.impl.presentation.view.dialogs.playlist_details

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import coil.load
import ru.kpfu.itis.bagaviev.common.base.music.BaseMusicDialogFragment
import ru.kpfu.itis.bagaviev.common.base.music.BaseMusicViewModel
import ru.kpfu.itis.bagaviev.common.util.extensions.observe
import ru.kpfu.itis.bagaviev.feed.impl.R
import ru.kpfu.itis.bagaviev.feed.impl.databinding.FragmentPlaylistDetailsBinding
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entity.playlist.PlaylistDetailsModel
import ru.kpfu.itis.bagaviev.feed.impl.presentation.view.FeedViewModel
import ru.kpfu.itis.bagaviev.feed.impl.presentation.view.recyclerview.mapper.toTrackRvModel
import ru.kpfu.itis.bagaviev.theme.recyclerview.adapter.TrackAdapter
import ru.kpfu.itis.bagaviev.theme.recyclerview.decoration.TrackItemDecoration
import ru.kpfu.itis.bagaviev.theme.recyclerview.intercator.TrackInteractor

class PlaylistDetailsDialogFragment : BaseMusicDialogFragment(R.layout.fragment_playlist_details) {

    private var viewBinding: FragmentPlaylistDetailsBinding? = null

    private val viewModel by lazy {
        ViewModelProvider(requireActivity())[FeedViewModel::class.java]
    }

    private val trackAdapter by lazy {
        TrackAdapter(
            context = requireContext(),
            trackInteractor = TrackInteractor.Builder()
                .onClick(viewModel::onTrackClick)
                .onMoveThumb(musicViewModel::onSeeking)
                .onReleaseThumb(musicViewModel::onSeekTo)
                .build()
        )
    }


    private fun observeCurrentPlayingProgressState(progress: Int) {
        trackAdapter.updatePlayingProgress(progress)
    }

    private fun observeCurrentIsPlayingState(isPlaying: Boolean) {
        trackAdapter.updateIsPlaying(isPlaying)
    }

    private fun observeCurrentMusicData(musicData: BaseMusicViewModel.MusicData?) {
        musicData?.apply {

        }
    }

    private fun initUi(playlistDetails: PlaylistDetailsModel) {
        viewBinding?.apply {
            playlistDetails.apply {
                with(requireContext().resources) {
                    tvTrackTitle.text = getString(
                        R.string.playlist_details_fragment_title, title
                    )
                    tvTrackAuthor.text = getString(
                        R.string.playlist_details_fragment_authors, author.login
                    )
                    tvTrackPlaysCount.text = getString(
                        R.string.playlist_details_fragment_plays_count, playsCount
                    )
                    tvTrackReleaseDate.text = getString(
                        R.string.playlist_details_fragment_release_date, createdTime
                    )
                    ivTrackCover.load(coverUri)
                    rvPlaylistTracks.adapter = trackAdapter.apply {
                        submitList(tracks.map { trackModel -> trackModel.toTrackRvModel() })
                    }
                    rvPlaylistTracks.addItemDecoration(TrackItemDecoration(requireContext()))
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentPlaylistDetailsBinding.inflate(
            inflater, container, false
        )
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        return viewBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val playlistDetails = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            arguments?.getParcelable(PLAYLIST_DETAILS_KEY, PlaylistDetailsModel::class.java)
        } else {
            arguments?.getParcelable(PLAYLIST_DETAILS_KEY)
        }

        playlistDetails?.also(::initUi)

        musicViewModel.apply {
            isPlayingState.observe(
                viewLifecycleOwner,
                ::observeCurrentIsPlayingState
            )
            playingProgressState.observe(
                viewLifecycleOwner,
                ::observeCurrentPlayingProgressState
            )
            currentMusicData.observe(
                viewLifecycleOwner,
                ::observeCurrentMusicData
            )
        }
    }

    companion object {

        private const val PLAYLIST_DETAILS_KEY = "playlistDetailsKey"

        fun newInstance(playlistDetails: PlaylistDetailsModel): PlaylistDetailsDialogFragment =
            PlaylistDetailsDialogFragment().apply {
                arguments = bundleOf(PLAYLIST_DETAILS_KEY to playlistDetails)
            }
    }
}