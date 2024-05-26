package ru.kpfu.itis.bagaviev.theme.recyclerview.viewholder

import androidx.core.view.isVisible
import coil.load
import ru.kpfu.itis.bagaviev.common.util.listeners.setOnSeekBarChangeListener
import ru.kpfu.itis.bagaviev.theme.R
import ru.kpfu.itis.bagaviev.theme.databinding.ItemTrackBinding
import ru.kpfu.itis.bagaviev.theme.recyclerview.intercator.TrackInteractor
import ru.kpfu.itis.bagaviev.theme.recyclerview.model.TrackRvModel

class TrackViewHolder(
    private val viewBinding: ItemTrackBinding,
    private val interactor: TrackInteractor
) : MusicComponentViewHolder(viewBinding.root) {

    private var currentTrackRvModel: TrackRvModel? = null

    init {
        viewBinding.apply {
            root.apply {
                setOnClickListener {
                    currentTrackRvModel?.apply { interactor.onClick(id) }
                }
                setOnLongClickListener {
                    currentTrackRvModel?.apply { interactor.onLongClick(id) }
                    true
                }
            }
            ivTrackSmallIcon.setOnClickListener {
                currentTrackRvModel?.apply { interactor.onSmallCoverClick(id) }
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


    fun bind(trackRvModel: TrackRvModel) {
        this.currentTrackRvModel = trackRvModel
        viewBinding.apply {
            trackRvModel.apply {
                tvTrackTitle.text = title
                tvTrackUsers.text = authorNames.joinToString(separator = " & ")
                ivTrackSmallIcon.load(smallCoverUri)
                ivPlayPause.isVisible = false
                sbTrackPlaying.isVisible = false
            }
        }
    }


    fun updateAsReadyToPlay() {
        viewBinding.apply {
            updateIsPlaying(true)
            updateProgress(0)
            ivPlayPause.isVisible = true
            sbTrackPlaying.isVisible = true
        }
    }

    fun updateAsStatic() {
        viewBinding.apply {
            ivPlayPause.isVisible = false
            sbTrackPlaying.isVisible = false
        }
    }

    fun updateIsPlaying(isPlaying: Boolean) {
        viewBinding.apply {
            ivPlayPause.setImageResource(
                if (isPlaying)
                    R.drawable.item_playing
                else
                    R.drawable.item_paused
            )
        }
    }

    fun updateProgress(progress: Int) {
        viewBinding.apply {
            sbTrackPlaying.progress = progress
        }
    }
}