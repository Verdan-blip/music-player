package ru.kpfu.itis.bagaviev.feed.impl.presentation.view.recyclerview.holder.feed

import ru.kpfu.itis.bagaviev.feed.impl.databinding.ItemPlaylistsBinding
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entities.playlists.PlaylistModel
import ru.kpfu.itis.bagaviev.feed.impl.presentation.view.recyclerview.adapter.PlaylistAdapter
import ru.kpfu.itis.bagaviev.feed.impl.presentation.view.recyclerview.decorator.PlaylistItemDecorator
import ru.kpfu.itis.bagaviev.feed.impl.presentation.view.recyclerview.holder.FeedViewHolder
import ru.kpfu.itis.bagaviev.feed.impl.presentation.view.recyclerview.holder.playlist.PlaylistViewHolder

class PlaylistsViewHolder(
    private val binding: ItemPlaylistsBinding,
    private val interactor: PlaylistViewHolder.Companion.PlaylistInteractor
) : FeedViewHolder(binding.root) {

    private val adapter: PlaylistAdapter = PlaylistAdapter(binding.root.context, interactor)

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