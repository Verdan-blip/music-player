package ru.kpfu.itis.bagaviev.feature.search.impl.presentation.view.reclycerview.holder

import ru.kpfu.itis.bagaviev.feature.search.impl.databinding.ItemPlaylistsBinding
import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.view.reclycerview.adapter.PlaylistsAdapter
import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.view.reclycerview.decorator.PlaylistItemDecorator
import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.entities.playlists.PlaylistModel
import ru.kpfu.itis.bagaviev.feed.impl.presentation.view.common.recyclerview.holder.PlaylistViewHolder

class PlaylistsViewHolder(
    private val viewBinding: ItemPlaylistsBinding,
    private val interactor: PlaylistViewHolder.Companion.PlaylistInteractor
) : PlayableInfoViewHolder(viewBinding.root) {

    private val playlistsAdapter = PlaylistsAdapter(viewBinding.root.context, interactor)

    init {
        viewBinding.apply {
            rvPlaylists.adapter = playlistsAdapter
            rvPlaylists.addItemDecoration(PlaylistItemDecorator(root.context))
        }
    }

    fun bind(playlistList: List<PlaylistModel>) {
        playlistsAdapter.submitList(playlistList)
    }
}