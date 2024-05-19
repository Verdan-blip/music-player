package ru.kpfu.itis.bagaviev.feed.impl.presentation.view.dialogs.playlist

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import coil.load
import ru.kpfu.itis.bagaviev.common.util.extensions.observe
import ru.kpfu.itis.bagaviev.feed.impl.R
import ru.kpfu.itis.bagaviev.feed.impl.databinding.FragmentPlaylistDetailsBinding
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entity.playlist.PlaylistDetailsModel
import ru.kpfu.itis.bagaviev.feed.impl.presentation.view.FeedViewModel
import ru.kpfu.itis.bagaviev.feed.impl.presentation.view.recyclerview.mappers.toTrackItem
import ru.kpfu.itis.bagaviev.feed.impl.presentation.view.state.FeedUiState
import ru.kpfu.itis.bagaviev.theme.recyclerview.adapter.TrackAdapter
import ru.kpfu.itis.bagaviev.theme.recyclerview.decorator.TrackItemDecorator
import ru.kpfu.itis.bagaviev.theme.recyclerview.interactor.TrackInteractor

class PlaylistDetailsDialogFragment : DialogFragment(R.layout.fragment_playlist_details) {

    private var viewBinding: FragmentPlaylistDetailsBinding? = null

    private val viewModel by lazy {
        ViewModelProvider(requireActivity())[FeedViewModel::class.java]
    }

    private val tracksAdapter by lazy {
        TrackAdapter(
            context = requireContext(),
            trackInteractor = TrackInteractor.Builder()
                .onClick(viewModel::onTrackClick)
                .onMoveHeldThumb(viewModel::onMoveHeldSeekBar)
                .onReleaseThumb(viewModel::onSeekTo)
                .build()
        )
    }


    private fun observeUiState(feedUiState: FeedUiState) {
        with(feedUiState) {
            with(tracksAdapter) {
                playingMusicItem?.apply{ markAsPlayable(id) }
                if (isPlaying) play() else pause()
            }
        }
    }

    private fun observeCurrentPlayingProgress(progress: Int) {
        tracksAdapter.updatePlayingProgress(progress)
    }

    private fun initUi(playlistDetails: PlaylistDetailsModel) {
        viewBinding?.apply {
            playlistDetails.apply {
                with(requireContext().resources) {
                    tvTrackTitle.text = getString(
                        R.string.playlist_details_fragment_title, title
                    )
                    tvTrackAuthor.text = getString(
                        R.string.playlist_details_fragment_authors, user.login
                    )
                    tvTrackPlaysCount.text = getString(
                        R.string.playlist_details_fragment_plays_count, playsCount
                    )
                    tvTrackReleaseDate.text = getString(
                        R.string.playlist_details_fragment_release_date, createdTime
                    )
                    ivTrackCover.load(coverUri)
                    rvPlaylistTracks.adapter = tracksAdapter.apply {
                        submitList(tracks.map { trackModel ->
                            trackModel.toTrackItem()
                        })
                    }
                    rvPlaylistTracks.addItemDecoration(TrackItemDecorator(requireContext()))
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
        viewModel.apply {
            uiState.observe(viewLifecycleOwner, ::observeUiState)
            currentPlayingProgressState.observe(viewLifecycleOwner, ::observeCurrentPlayingProgress)
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