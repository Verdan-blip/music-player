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
import ru.kpfu.itis.bagaviev.feed.impl.presentation.view.dialogs.playlist.PlaylistDetailsDialogFragment
import ru.kpfu.itis.bagaviev.feed.impl.presentation.view.dialogs.track.TrackDetailsDialogFragment
import ru.kpfu.itis.bagaviev.feed.impl.presentation.view.recyclerview.adapter.FeedAdapter
import ru.kpfu.itis.bagaviev.feed.impl.presentation.view.recyclerview.decorator.FeedItemDecorator
import ru.kpfu.itis.bagaviev.feed.impl.presentation.view.recyclerview.mappers.toPlaylistItem
import ru.kpfu.itis.bagaviev.feed.impl.presentation.view.recyclerview.mappers.toTrackItem
import ru.kpfu.itis.bagaviev.feed.impl.presentation.view.state.DialogState
import ru.kpfu.itis.bagaviev.feed.impl.presentation.view.state.FeedUiState
import ru.kpfu.itis.bagaviev.theme.recyclerview.interactor.PlaylistInteractor
import ru.kpfu.itis.bagaviev.theme.recyclerview.interactor.TrackInteractor

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
        with(requireContext().resources) {
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
    }

    private fun observeUiState(state: FeedUiState) {
        with(state) {
            with(feedAdapter) {
                if (isPlaying) play() else pause()
                submitList(popularTracks.map { trackModel ->
                    trackModel.toTrackItem()
                }) {
                    playingMusicItem?.apply { feedAdapter.markAsPlayable(id) }
                }
                submitPlaylistList(popularPlaylists.map { playlistModel ->
                    playlistModel.toPlaylistItem()
                })
                loadBackgroundImage(background)
            }

            viewBinding?.apply {
                layoutPlayingTrack.apply {
                    if (playingMusicItem != null) {
                        root.isVisible = true
                        tvPlayingTrackTitle.text = playingMusicItem.title
                        tvPlayingTrackAuthors.text = playingMusicItem
                            .authors.joinToString(separator = " & ")
                        ivPlayingTrackCover.load(background)
                    } else {
                        root.isVisible = false
                    }
                }
            }
        }
    }

    private fun observeCurrentPlayingProgress(progress: Int) {
        feedAdapter.updatePlayingProgress(progress)
        viewBinding?.layoutPlayingTrack
            ?.sbPlayingTrackProgress?.progress = progress
    }

    private fun observeDialogState(dialogState: DialogState) {
        when (dialogState) {
            is DialogState.TrackDetails -> {
                val dialogFragment = TrackDetailsDialogFragment
                    .newInstance(dialogState.trackDetails)
                dialogFragment.show(childFragmentManager, null)
            }
            is DialogState.PlaylistDetails -> {
                val dialogFragment = PlaylistDetailsDialogFragment
                    .newInstance(dialogState.playlistDetails)
                dialogFragment.show(childFragmentManager, null)
            }
        }
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
            currentPlayingProgressState.observe(viewLifecycleOwner, ::observeCurrentPlayingProgress)
            dialogState.observe(viewLifecycleOwner, ::observeDialogState)
        }

        viewBinding?.apply {
            rvChartTracks.adapter = feedAdapter
            rvChartTracks.addItemDecoration(FeedItemDecorator(requireContext()))
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