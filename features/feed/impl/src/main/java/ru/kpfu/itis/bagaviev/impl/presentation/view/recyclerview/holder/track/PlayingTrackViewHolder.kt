package ru.kpfu.itis.bagaviev.impl.presentation.view.recyclerview.holder.track

import coil.load
import ru.kpfu.itis.bagaviev.impl.databinding.ItemPlayingTrackBinding
import ru.kpfu.itis.bagaviev.impl.presentation.entities.tracks.TrackModel
import ru.kpfu.itis.bagaviev.impl.presentation.view.recyclerview.holder.FeedViewHolder
import ru.kpfu.itis.common.util.listeners.setOnSeekBarChangeListener

class PlayingTrackViewHolder(
    private val binding: ItemPlayingTrackBinding,
    private val interactor: PlayingTrackInteractor
) : FeedViewHolder(binding.root) {

    private var isPlaying: Boolean = false

    private var track: TrackModel? = null

    init {
        binding.apply {
            progressBarTrackPlaying.setOnSeekBarChangeListener(
                onStopTrackingTouch = { seekBar ->
                    seekBar?.apply { interactor.onSeekTo(progress) }
                }
            )
            root.setOnClickListener {
                track?.apply { interactor.onClick(id) }
            }
            ibPlayPause.setOnClickListener {
                interactor.onPlayPause()
            }
        }
    }

    fun bind(track: TrackModel, isPlaying: Boolean = false, progress: Int = 0) {
        this.isPlaying = isPlaying
        binding.apply {
            tvTrackTitle.text = track.title
            tvTrackUsers.text = track.users.joinToString(separator = " & ") { user -> user.login }
            ivTrackSmallIcon.load(track.smallCoverUri)
            progressBarTrackPlaying.progress = progress
            ibPlayPause.setImageResource(
                if (isPlaying)
                    ru.kpfu.itis.bagaviev.theme.R.drawable.item_paused
                else
                    ru.kpfu.itis.bagaviev.theme.R.drawable.item_playing
            )
        }
    }

    companion object {

        interface PlayingTrackInteractor {

            fun onClick(trackId: Long)

            fun onPlayPause()

            fun onSeekTo(progress: Int)
        }
    }
}