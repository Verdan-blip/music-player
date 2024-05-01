package ru.kpfu.itis.bagaviev.impl.presentation.view.recyclerview.holder.feed

import ru.kpfu.itis.bagaviev.impl.databinding.ItemPlaylistsBinding
import ru.kpfu.itis.bagaviev.impl.presentation.entities.playlists.PlaylistModel
import ru.kpfu.itis.bagaviev.impl.presentation.view.recyclerview.adapter.PlaylistAdapter
import ru.kpfu.itis.bagaviev.impl.presentation.view.recyclerview.decorator.PlaylistItemDecorator
import ru.kpfu.itis.bagaviev.impl.presentation.view.recyclerview.holder.FeedViewHolder

class PlaylistsViewHolder(
    private val binding: ItemPlaylistsBinding,
) : FeedViewHolder(binding.root) {

    private val adapter: PlaylistAdapter = PlaylistAdapter(binding.root.context)

    init {
        binding.apply {
            rvPlaylists.adapter = adapter
            rvPlaylists.addItemDecoration(PlaylistItemDecorator(binding.root.context))
        }
    }

    fun bind(playlistList: List<PlaylistModel>) {
        binding.apply {
            adapter.submitList(playlistList)
        }
    }
}