package ru.kpfu.itis.bagaviev.feed.impl.presentation.view.recyclerview.holder.playlist

import coil.load
import ru.kpfu.itis.bagaviev.feed.impl.databinding.ItemPlaylistBinding
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entities.playlists.PlaylistModel
import ru.kpfu.itis.bagaviev.feed.impl.presentation.view.recyclerview.holder.FeedViewHolder

class PlaylistViewHolder(
    private val binding: ItemPlaylistBinding,
    private val interactor: PlaylistInteractor
) : FeedViewHolder(binding.root) {

    private var playlist: PlaylistModel? = null

    init {
        binding.root.setOnClickListener {
            playlist?.apply {
                interactor.onClick(id)
            }
        }
    }

    fun bind(playlist: PlaylistModel) {
        this.playlist = playlist
        binding.apply {
            tvTitle.text = playlist.title
            ivCover.load(playlist.coverUri)
        }
    }

    companion object {

        interface PlaylistInteractor {

            fun onClick(playlistId: Long)
        }
    }
}