package ru.kpfu.itis.bagaviev.impl.presentation.view.recyclerview.holder.playlist

import coil.load
import ru.kpfu.itis.bagaviev.impl.databinding.ItemPlaylistBinding
import ru.kpfu.itis.bagaviev.impl.presentation.entities.playlists.PlaylistModel
import ru.kpfu.itis.bagaviev.impl.presentation.view.recyclerview.holder.FeedViewHolder

class PlaylistViewHolder(
    private val binding: ItemPlaylistBinding
) : FeedViewHolder(binding.root) {

    fun bind(playlistModel: PlaylistModel) {
        binding.apply {
            tvTitle.text = playlistModel.title
            ivCover.load(playlistModel.coverUri)
        }
    }
}