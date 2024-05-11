package ru.kpfu.itis.bagaviev.feed.impl.presentation.view.recyclerview.holder

import ru.kpfu.itis.bagaviev.feed.impl.databinding.ItemPlaylistsBinding
import ru.kpfu.itis.bagaviev.theme.recyclerview.adapter.PlaylistAdapter
import ru.kpfu.itis.bagaviev.theme.recyclerview.decorator.PlaylistItemDecorator
import ru.kpfu.itis.bagaviev.theme.recyclerview.interactor.PlaylistInteractor
import ru.kpfu.itis.bagaviev.theme.recyclerview.model.PlaylistItem
import ru.kpfu.itis.bagaviev.theme.recyclerview.viewholder.PlayableViewHolder

class PlaylistsViewHolder(
    private val viewBinding: ItemPlaylistsBinding,
    private val interactor: PlaylistInteractor
) : PlayableViewHolder(viewBinding.root) {

    private val playlistAdapter = PlaylistAdapter(viewBinding.root.context, interactor)

    init {
        viewBinding.apply {
            rvPlaylists.adapter = playlistAdapter
            rvPlaylists.addItemDecoration(PlaylistItemDecorator(root.context))
        }
    }

    fun bind(playlistList: List<PlaylistItem>) {
        playlistAdapter.submitList(playlistList)
    }
}