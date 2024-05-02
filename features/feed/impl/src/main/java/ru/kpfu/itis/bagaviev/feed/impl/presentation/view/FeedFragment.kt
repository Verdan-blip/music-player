package ru.kpfu.itis.bagaviev.feed.impl.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import jp.wasabeef.blurry.Blurry
import ru.kpfu.itis.bagaviev.feed.impl.R
import ru.kpfu.itis.bagaviev.feed.impl.databinding.FragmentFeedBinding
import ru.kpfu.itis.bagaviev.feed.impl.di.FeedComponentHolder
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entities.playlists.PlaylistModel
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entities.tracks.TrackDetailsModel
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entities.tracks.TrackModel
import ru.kpfu.itis.bagaviev.feed.impl.presentation.view.recyclerview.adapter.FeedAdapter
import ru.kpfu.itis.bagaviev.feed.impl.presentation.view.recyclerview.decorator.FeedItemDecorator
import ru.kpfu.itis.bagaviev.feed.impl.presentation.view.recyclerview.holder.playlist.PlaylistViewHolder
import ru.kpfu.itis.bagaviev.feed.impl.presentation.view.recyclerview.holder.track.TrackViewHolder
import ru.kpfu.itis.common.base.BaseFragment
import ru.kpfu.itis.common.util.extensions.observe

class FeedFragment : BaseFragment(R.layout.fragment_feed) {

    private var viewBinding: FragmentFeedBinding? = null

    private val feedAdapter by lazy {
        FeedAdapter(
            requireContext(),
            object : TrackViewHolder.Companion.TrackInteractor {

                override fun onClick(trackId: Long) {
                    viewModel.onTrackClick(trackId)
                }

                override fun onPlayPause() {
                    viewModel.onPlayPause()
                }

                override fun onSeekTo(progress: Int) {
                    viewModel.onSeekTo(progress)
                }
            },
            object : PlaylistViewHolder.Companion.PlaylistInteractor {

                override fun onClick(playlistId: Long) {

                    viewModel.onPlaylistClick(playlistId)
                }
            }
        )
    }

    private val viewModel: FeedViewModel by viewModels {
        with (FeedComponentHolder) {
            provideContext(requireContext().applicationContext)
            buildComponent()
            bind(requireActivity().lifecycle)
            requireComponent()
        }.viewModelFactory
    }

    private fun observeLoadedTracks(trackList: List<TrackModel>) {
        viewBinding?.apply {
            feedAdapter.submitTrackList(trackList)
        }
    }

    private fun observeLoadedPlaylists(playlist: List<PlaylistModel>) {
        viewBinding?.apply {
            feedAdapter.submitPlaylistList(playlist)
        }
    }

    private fun observeCurrentPlayingItemProgress(progress: Int?) {
        progress?.also { progressValue ->
            feedAdapter.updatePlayingProgress(progressValue)
        }
    }

    private fun observeCurrentPlayingTrackId(trackId: Long?) {
        trackId?.also { id ->
            feedAdapter.setPlayingTrack(id)
            viewModel.onGetTrackDetails(trackId)
        }
    }

    private fun observeIsPlayingState(isPlayingState: Boolean?) {
        isPlayingState?.also { isPlaying ->
            if (isPlaying)
                feedAdapter.play()
            else
                feedAdapter.pause()
        }
    }

    private fun observeTrackDetailsState(trackDetails: TrackDetailsModel?) {
        trackDetails?.apply {
            viewBinding?.apply {
                enqueueLoadImageRequest(
                    data = coverUri,
                    allowHardware = false,
                    onSuccess = { _, resp ->
                        ivBackground.setImageDrawable(resp.drawable)
                        Blurry.with(context)
                            .radius(resources.getInteger(
                                ru.kpfu.itis.bagaviev.theme.R.integer.blur_radius)
                            )
                            .sampling(resources.getInteger(
                                ru.kpfu.itis.bagaviev.theme.R.integer.blur_sampling)
                            )
                            .capture(ivBackground)
                            .into(ivBackground)
                        ivFloatingPlayingTrack.setImageDrawable(resp.drawable)
                    }
                )
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentFeedBinding.inflate(inflater, container, false)
        viewBinding?.apply {
            rvChartTracks.adapter = feedAdapter
            rvChartTracks.addItemDecoration(FeedItemDecorator(requireContext()))
            rvChartTracks.itemAnimator = null
            ivFloatingPlayingTrack.setOnClickListener {
                viewModel.onFloatingTrackClick()
            }
        }
        return viewBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(viewModel) {
            onLoadTracks()
            onLoadPlaylists()
            cartTracks.observe(viewLifecycleOwner, ::observeLoadedTracks)
            currentPlayingItemProgress.observe(viewLifecycleOwner, ::observeCurrentPlayingItemProgress)
            currentPlayingTrackId.observe(viewLifecycleOwner, ::observeCurrentPlayingTrackId)
            isPlayingState.observe(viewLifecycleOwner, ::observeIsPlayingState)
            trackDetails.observe(viewLifecycleOwner, ::observeTrackDetailsState)
            popularPlaylists.observe(viewLifecycleOwner, ::observeLoadedPlaylists)
        }
    }
}