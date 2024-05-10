package ru.kpfu.itis.bagaviev.feed.impl.presentation.view.recyclerview.holder

import androidx.annotation.DrawableRes
import androidx.core.view.isVisible
import coil.load
import ru.kpfu.itis.bagaviev.feed.impl.databinding.ItemTrackBinding
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entities.tracks.TrackModel
import ru.kpfu.itis.bagaviev.common.util.listeners.setOnSeekBarChangeListener

class TrackViewHolder(
    private val viewBinding: ItemTrackBinding,
    private val interactor: TrackInteractor
) : PlayableInfoViewHolder(viewBinding.root) {

    private var trackModel: TrackModel? = null

    init {
        viewBinding.apply {
            pbTrackPlaying.setOnSeekBarChangeListener(
                onStartTrackingTouch = { seekBar ->
                    seekBar?.apply { interactor.onMoveHeldThumb(progress) }
                },
                onStopTrackingTouch = { seekBar ->
                    seekBar?.apply { interactor.onSeekTo(progress) }
                }
            )
            root.setOnClickListener {
                trackModel?.apply { interactor.onClick(id) }
            }
            root.setOnLongClickListener {
                trackModel?.apply { interactor.onLongClick(id) }
                true
            }
        }
    }

    fun bind(track: TrackModel, trackState: TrackState) {
        this.trackModel = track

        viewBinding.apply {
            tvTrackTitle.text = track.title
            tvTrackUsers.text = track.users.joinToString(separator = " & ") { user -> user.login }
            ivTrackSmallIcon.load(track.smallCoverUri)
            when (trackState) {
                is TrackState.Static -> {
                    setPlayingStateShowingViewsVisibility(false)
                }
                is TrackState.Playing -> {
                    setPlayingStateShowingViewsVisibility(true)
                    rebind(trackState.progress)
                    rebind(trackState.isPlaying)
                }
            }
        }
    }

    fun rebind(isPlaying: Boolean) {
        viewBinding.ibPlayPause.setImageResource(getDrawableResByPlayingState(isPlaying))
    }

    fun rebind(progress: Int) {
        viewBinding.pbTrackPlaying.progress = progress
    }

    @DrawableRes
    private fun getDrawableResByPlayingState(isPlaying: Boolean): Int =
        if (isPlaying)
            ru.kpfu.itis.bagaviev.theme.R.drawable.item_paused
        else
            ru.kpfu.itis.bagaviev.theme.R.drawable.item_playing

    private fun setPlayingStateShowingViewsVisibility(visible: Boolean) {
        viewBinding.apply {
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