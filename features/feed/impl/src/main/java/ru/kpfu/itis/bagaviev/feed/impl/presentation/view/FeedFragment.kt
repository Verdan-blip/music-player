package ru.kpfu.itis.bagaviev.feed.impl.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import ru.kpfu.itis.bagaviev.common.base.music.BaseMusicFragment
import ru.kpfu.itis.bagaviev.common.util.extensions.observe
import ru.kpfu.itis.bagaviev.feed.impl.R
import ru.kpfu.itis.bagaviev.feed.impl.databinding.FragmentFeedBinding
import ru.kpfu.itis.bagaviev.feed.impl.di.FeedComponentHolder
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entity.track.TrackDetailsModel
import ru.kpfu.itis.bagaviev.feed.impl.presentation.event.DialogEvent
import ru.kpfu.itis.bagaviev.feed.impl.presentation.state.FeedUiState
import ru.kpfu.itis.bagaviev.feed.impl.presentation.view.dialogs.playlist_details.PlaylistDetailsDialogFragment
import ru.kpfu.itis.bagaviev.feed.impl.presentation.view.dialogs.track_details.TrackDetailsDialogFragment
import ru.kpfu.itis.bagaviev.feed.impl.presentation.view.recyclerview.adapter.FeedAdapter
import ru.kpfu.itis.bagaviev.feed.impl.presentation.view.recyclerview.decorator.FeedItemDecoration
import ru.kpfu.itis.bagaviev.feed.impl.presentation.view.recyclerview.mapper.toPlaylistRvModel
import ru.kpfu.itis.bagaviev.feed.impl.presentation.view.recyclerview.mapper.toTrackRvModel
import ru.kpfu.itis.bagaviev.feed.impl.presentation.view.util.toMusicData
import ru.kpfu.itis.bagaviev.feed.impl.presentation.view.util.toTrackRvModel
import ru.kpfu.itis.bagaviev.theme.recyclerview.intercator.PlaylistInteractor
import ru.kpfu.itis.bagaviev.theme.recyclerview.intercator.TrackInteractor

class FeedFragment : BaseMusicFragment(R.layout.fragment_feed) {

    private var viewBinding: FragmentFeedBinding? = null

    private val feedAdapter by lazy {
        FeedAdapter(
            context = requireContext(),
            trackInteractor = TrackInteractor.Builder()
                .onClick(viewModel::onTrackClick)
                .onLongClick(viewModel::onTrackLongClick)
                .onMoveThumb(musicViewModel::onSeeking)
                .onReleaseThumb(musicViewModel::onSeekTo)
                .onPlayPauseClick(musicViewModel::onPlayPause)
                .onDownloadClick(viewModel::onDownloadTrackClick)
                .build(),
            playlistInteractor = PlaylistInteractor.Builder()
                .onClick(viewModel::onPlaylistClick)
                .onLongClick(viewModel::onPlaylistLongClick)
                .build()
        )
    }


    private val viewModel: FeedViewModel by activityViewModels {
        FeedComponentHolder
            .createComponent(requireContext())
            .viewModelFactory
    }


    private fun observeUiState(state: FeedUiState) {
        with(state) {
            with(feedAdapter) {
                submitData(
                    tracks = popularTracks.map { trackModel ->
                        trackModel.toTrackRvModel()
                    },
                    playlists = popularPlaylists.map { playlistModel ->
                        playlistModel.toPlaylistRvModel()
                    },
                    authors = listOf()
                )
            }
        }
    }


    private fun observeSelectedTrackDetailsState(trackDetailsModel: TrackDetailsModel?) {
        trackDetailsModel?.apply {
            feedAdapter.prepareToPlay(toTrackRvModel())
            musicViewModel.onPlay(toMusicData())
        }
    }

    private fun observeSelectedTrackDetailsToDownloadEvent(trackDetailsModel: TrackDetailsModel?) {
        trackDetailsModel?.apply {
            musicViewModel.onDownload(toMusicData())
        }
    }


    private fun observeProgressState(progress: Int) {
        feedAdapter.updatePlayingProgress(progress)
    }

    private fun observeIsPlayingState(isPlaying: Boolean) {
        feedAdapter.updateIsPlaying(isPlaying)
    }


    private fun observeDialogEvent(dialogEvent: DialogEvent) {
        when (dialogEvent) {
            is DialogEvent.TrackDetails -> {
                val dialogFragment = TrackDetailsDialogFragment
                    .newInstance(dialogEvent.trackDetails)
                dialogFragment.show(childFragmentManager, null)
            }
            is DialogEvent.PlaylistDetails -> {
                val dialogFragment = PlaylistDetailsDialogFragment
                    .newInstance(dialogEvent.playlistDetails)
                dialogFragment.show(childFragmentManager, null)
            }
        }
    }

    private fun observeErrorAlert(message: String) {
        showErrorDialog(
            requireContext().getString(ru.kpfu.itis.bagaviev.theme.R.string.error_dialog_title),
            message
        )
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentFeedBinding.inflate(inflater, container, false)
        return viewBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.apply {
            uiState.observe(viewLifecycleOwner, ::observeUiState)
            dialogEvent.observe(viewLifecycleOwner, ::observeDialogEvent)
            selectedTrackDetailsEvent.observe(
                viewLifecycleOwner,
                ::observeSelectedTrackDetailsState
            )
            selectedTrackDetailsToDownloadEvent.observe(
                viewLifecycleOwner,
                ::observeSelectedTrackDetailsToDownloadEvent
            )
            errorAlert.observe(viewLifecycleOwner, ::observeErrorAlert)
        }

        musicViewModel.apply {
            playingProgressState.observe(viewLifecycleOwner, ::observeProgressState)
            isPlayingState.observe(viewLifecycleOwner, ::observeIsPlayingState)
        }

        viewBinding?.apply {
            rvChartTracks.adapter = feedAdapter
            rvChartTracks.addItemDecoration(FeedItemDecoration(requireContext()))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }

    override fun onDestroy() {
        super.onDestroy()
        FeedComponentHolder.releaseComponent()
    }
}