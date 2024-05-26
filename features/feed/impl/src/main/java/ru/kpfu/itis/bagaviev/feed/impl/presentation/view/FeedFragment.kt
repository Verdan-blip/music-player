package ru.kpfu.itis.bagaviev.feed.impl.presentation.view

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import coil.ImageLoader
import coil.load
import coil.memory.MemoryCache
import coil.request.ImageRequest
import ru.kpfu.itis.bagaviev.common.WithAdaptiveBackground
import ru.kpfu.itis.bagaviev.common.base.BaseFragment
import ru.kpfu.itis.bagaviev.common.util.extensions.observe
import ru.kpfu.itis.bagaviev.common.util.listeners.setOnSeekBarChangeListener
import ru.kpfu.itis.bagaviev.feed.impl.R
import ru.kpfu.itis.bagaviev.feed.impl.databinding.FragmentFeedBinding
import ru.kpfu.itis.bagaviev.feed.impl.di.FeedComponentHolder
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entity.track.TrackModel
import ru.kpfu.itis.bagaviev.feed.impl.presentation.event.DialogEvent
import ru.kpfu.itis.bagaviev.feed.impl.presentation.state.FeedUiState
import ru.kpfu.itis.bagaviev.feed.impl.presentation.view.dialogs.playlist.PlaylistDetailsDialogFragment
import ru.kpfu.itis.bagaviev.feed.impl.presentation.view.dialogs.track.TrackDetailsDialogFragment
import ru.kpfu.itis.bagaviev.feed.impl.presentation.view.recyclerview.adapter.FeedAdapter
import ru.kpfu.itis.bagaviev.feed.impl.presentation.view.recyclerview.decorator.FeedItemDecoration
import ru.kpfu.itis.bagaviev.feed.impl.presentation.view.recyclerview.mapper.toPlaylistRvModel
import ru.kpfu.itis.bagaviev.feed.impl.presentation.view.recyclerview.mapper.toTrackRvModel
import ru.kpfu.itis.bagaviev.theme.recyclerview.intercator.PlaylistInteractor
import ru.kpfu.itis.bagaviev.theme.recyclerview.intercator.TrackInteractor

class FeedFragment : BaseFragment(R.layout.fragment_feed) {

    private var viewBinding: FragmentFeedBinding? = null

    private val feedAdapter by lazy {
        FeedAdapter(
            context = requireContext(),
            trackInteractor = TrackInteractor.Builder()
                .onClick(viewModel::onTrackClick)
                .onLongClick(viewModel::onTrackLongClick)
                .onMoveHeldThumb(viewModel::onMoveHeldSeekBar)
                .onReleaseThumb(viewModel::onSeekTo)
                .build(),
            playlistInteractor = PlaylistInteractor.Builder()
                .onClick(viewModel::onPlaylistClick)
                .onLongClick(viewModel::onPlaylistLongClick)
                .build()
        )
    }

    private val viewModel: FeedViewModel by viewModels(ownerProducer = ::requireActivity) {
        FeedComponentHolder
            .createComponent(requireContext())
            .viewModelFactory
    }

    private fun initListeners() {
        viewBinding?.layoutPlayingTrack?.sbPlayingTrackProgress?.setOnSeekBarChangeListener(
            onStartTrackingTouch = { seekBar ->
                seekBar?.apply { viewModel.onMoveHeldSeekBar(progress) }
            },
            onStopTrackingTouch = { seekBar ->
                seekBar?.apply { viewModel.onSeekTo(progress) }
            }
        )
    }

    private fun loadBackgroundImage(uri: Uri?) {
        val imageRequest = ImageRequest.Builder(requireContext())
            .data(uri)
            .allowHardware(false)
            .listener { _, result ->
                (requireContext() as WithAdaptiveBackground)
                    .updateBackground(result.drawable)
            }
            .build()
        ImageLoader.Builder(requireContext())
            .memoryCache {
                MemoryCache.Builder(requireContext())
                    .maxSizePercent(0.25)
                    .build()
            }
            .build()
            .enqueue(imageRequest)
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
                    users = listOf(),
                    ::observePlayingTrackData
                )
                loadBackgroundImage(background)
            }
        }
    }

    private fun observeCurrentPlayingTrackItemState(trackRvModel: TrackModel?) {
        trackRvModel?.also { track ->
            feedAdapter.prepareToPlay(track.toTrackRvModel())
            viewBinding?.apply {
                layoutPlayingTrack.apply {
                    root.isVisible = true
                    tvPlayingTrackTitle.text = track.title
                    tvPlayingTrackAuthors.text = track
                        .authorNames.joinToString(separator = " & ")
                    ivPlayingTrackCover.load(track.smallCoverUri)
                }
            }
        }
    }

    private fun observeCurrentPlayingProgressState(progress: Int) {
        feedAdapter.updatePlayingProgress(progress)
    }

    private fun observeCurrentIsPlayingState(isPlaying: Boolean) {
        feedAdapter.updateIsPlaying(isPlaying)
    }

    private fun observePlayingTrackData() {
        viewModel.apply {
            currentPlayingTrackModelState.observe(
                viewLifecycleOwner,
                ::observeCurrentPlayingTrackItemState
            )
            currentPlayingProgressState.observe(
                viewLifecycleOwner,
                ::observeCurrentPlayingProgressState
            )
            currentIsPlayingState.observe(
                viewLifecycleOwner,
                ::observeCurrentIsPlayingState
            )
        }
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
        showErrorDialog("Ошибка", message)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentFeedBinding.inflate(inflater, container, false)
        initListeners()
        return viewBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.apply {
            uiState.observe(viewLifecycleOwner, ::observeUiState)
            dialogEvent.observe(viewLifecycleOwner, ::observeDialogEvent)
            errorAlert.observe(viewLifecycleOwner, ::observeErrorAlert)
        }

        viewBinding?.apply {
            rvChartTracks.adapter = feedAdapter
            rvChartTracks.addItemDecoration(FeedItemDecoration(requireContext()))
            layoutPlayingTrack.root.setOnClickListener {
                viewModel.onFloatingTrackClick()
            }
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