package ru.kpfu.itis.bagaviev.impl.presentation.view.recyclerview.holder.track

import coil.load
import ru.kpfu.itis.bagaviev.impl.databinding.ItemTrackBinding
import ru.kpfu.itis.bagaviev.impl.presentation.entities.tracks.TrackModel
import ru.kpfu.itis.bagaviev.impl.presentation.view.recyclerview.holder.FeedViewHolder

class TrackViewHolder(
    private var binding: ItemTrackBinding,
    private var interactor: PlayingTrackViewHolder.Companion.PlayingTrackInteractor
) : FeedViewHolder(binding.root) {

    private var currentTrack: TrackModel? = null

    init {
        binding.root.setOnClickListener {
            currentTrack?.also {
                track -> interactor.onClick(track.id)
            }
        }
    }

    fun bind(track: TrackModel) {
        this.currentTrack = track
        binding.apply {
            tvTrackTitle.text = track.title
            tvTrackUsers.text = track.users.joinToString(separator = " & ") { user -> user.login }
            ivTrackSmallIcon.load(track.smallCoverUri)
        }
    }
}