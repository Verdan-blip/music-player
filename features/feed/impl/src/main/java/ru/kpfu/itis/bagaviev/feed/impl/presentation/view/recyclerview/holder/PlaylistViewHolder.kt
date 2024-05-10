package ru.kpfu.itis.bagaviev.feed.impl.presentation.view.recyclerview.holder

import coil.load
import ru.kpfu.itis.bagaviev.feed.impl.databinding.ItemPlaylistBinding
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entities.playlists.PlaylistModel

class PlaylistViewHolder(
    private val binding: ItemPlaylistBinding,
    private val interactor: PlaylistInteractor
) : PlayableInfoViewHolder(binding.root) {

    private var playlist: PlaylistModel? = null

    init {
        binding.apply {
            root.setOnClickListener {
                playlist?.apply {
                    interactor.onClick(id)
                }
            }
            root.setOnLongClickListener {
                playlist?.apply {
                    interactor.onLongClick(id)
                }
                true
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

            fun onLongClick(playlistId: Long)
        }
    }
}