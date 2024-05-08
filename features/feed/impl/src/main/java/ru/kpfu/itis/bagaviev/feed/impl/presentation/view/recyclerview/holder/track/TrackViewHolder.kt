package ru.kpfu.itis.bagaviev.feed.impl.presentation.view.recyclerview.holder.track

import androidx.annotation.DrawableRes
import androidx.core.view.isVisible
import coil.load
import ru.kpfu.itis.bagaviev.feed.impl.databinding.ItemTrackBinding
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entities.tracks.TrackModel
import ru.kpfu.itis.bagaviev.feed.impl.presentation.view.recyclerview.holder.FeedViewHolder
import ru.kpfu.itis.bagaviev.common.util.listeners.setOnSeekBarChangeListener

class TrackViewHolder(
    private val binding: ItemTrackBinding,
    private val interactor: TrackInteractor
) : FeedViewHolder(binding.root) {

    private var track: TrackModel? = null

    init {
        binding.apply {
            pbTrackPlaying.setOnSeekBarChangeListener(
                onStartTrackingTouch = { seekBar ->
                    seekBar?.apply { interactor.onMoveHeldThumb(progress) }
                },
                onStopTrackingTouch = { seekBar ->
                    seekBar?.apply { interactor.onSeekTo(progress) }
                }
            )
            root.setOnClickListener {
                track?.apply { interactor.onClick(id) }
            }
            root.setOnLongClickListener {
                track?.apply { interactor.onLongClick(id) }
                true
            }
        }
    }

    fun bind(track: TrackModel, trackState: TrackState) {
        this.track = track

        binding.apply {
            tvTrackTitle.text = track.title
            tvTrackUsers.text = track.users.joinToString(separator = " & ") { user -> user.login }
            ivTrackSmallIcon.load(track.smallCoverUri)
            when (trackState) {
                is TrackState.Static -> {
                    setPlayingStateShowingViewsVisibility(false)
                }
                is TrackState.Playing -> {
                    setPlayingStateShowingViewsVisibility(true)
                    pbTrackPlaying.progress = trackState.progress
                    ibPlayPause.setImageResource(getDrawableResByPlayingState(trackState.isPlaying))
                }
            }
        }
    }

    @DrawableRes
    private fun getDrawableResByPlayingState(isPlaying: Boolean): Int =
        if (isPlaying)
            ru.kpfu.itis.bagaviev.theme.R.drawable.item_paused
        else
            ru.kpfu.itis.bagaviev.theme.R.drawable.item_playing

    private fun setPlayingStateShowingViewsVisibility(visible: Boolean) {
        binding.apply {
            pbTrackPlaying.isVisible = visible
            ibPlayPause.isVisible = visible
        }
    }


    companion object {

        sealed class TrackState {
            data class Playing(
                val isPlaying: Boolean,
                val progress: Int
            ) : TrackState()

            data object Static : TrackState()
        }

        interface TrackInteractor {

            fun onClick(trackId: Long)

            fun onLongClick(trackId: Long)

            fun onPlayPause()

            fun onMoveHeldThumb(progress: Int)

            fun onSeekTo(progress: Int)
        }
    }
}