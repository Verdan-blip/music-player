package ru.kpfu.itis.bagaviev.theme.recyclerview.viewholder

import androidx.core.view.isVisible
import coil.load
import ru.kpfu.itis.bagaviev.common.util.listeners.setOnSeekBarChangeListener
import ru.kpfu.itis.bagaviev.theme.R
import ru.kpfu.itis.bagaviev.theme.databinding.ItemTrackBinding
import ru.kpfu.itis.bagaviev.theme.recyclerview.interactor.TrackInteractor
import ru.kpfu.itis.bagaviev.theme.recyclerview.model.TrackItem
import ru.kpfu.itis.bagaviev.theme.recyclerview.model.TrackState

class TrackViewHolder(
    private val viewBinding: ItemTrackBinding,
    private val interactor: TrackInteractor
) : PlayableViewHolder(viewBinding.root) {

    private var trackItem: TrackItem? = null

    init {
        viewBinding.apply {
            root.setOnClickListener {
                trackItem?.apply { interactor.onClick(id) }
            }
            root.setOnLongClickListener {
                trackItem?.apply { interactor.onLongClick(id) }
                true
            }
            ivTrackSmallIcon.setOnClickListener {
                trackItem?.apply { interactor.onSmallCoverClick(id) }
            }
            sbTrackPlaying.setOnSeekBarChangeListener(
                onStartTrackingTouch = { seekBar ->
                    seekBar?.apply { interactor.onMoveHeldThumb(progress) }
                },
                onStopTrackingTouch = { seekBar ->
                    seekBar?.apply { interactor.onReleaseThumb(progress) }
                }
            )
        }
    }

    fun bind(trackItem: TrackItem, state: TrackState) {
        this.trackItem = trackItem
        viewBinding.apply {
            trackItem.apply {
                tvTrackTitle.text = title
                tvTrackUsers.text = users.joinToString(separator = " & ")
                ivTrackSmallIcon.load(smallCoverUri)
                bindState(state)
            }
        }
    }

    fun bindState(state: TrackState) {
        viewBinding.apply {
            when (state) {
                is TrackState.Static -> {
                    ivPlayPause.isVisible = false
                    sbTrackPlaying.isVisible = false
                }
                is TrackState.MarkedAsPlaying -> {
                    ivPlayPause.isVisible = true
                    sbTrackPlaying.isVisible = true

                    ivPlayPause.setImageResource(R.drawable.item_paused)
                    sbTrackPlaying.progress = state.progress
                }
                is TrackState.MarkedAsPaused -> {
                    ivPlayPause.isVisible = true
                    sbTrackPlaying.isVisible = true

                    ivPlayPause.setImageResource(R.drawable.item_playing)
                    sbTrackPlaying.progress = state.progress
                }
            }
        }
    }
}