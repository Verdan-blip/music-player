package ru.kpfu.itis.bagaviev.feed.impl.presentation.view.recyclerview.holder

import ru.kpfu.itis.bagaviev.feed.impl.databinding.ItemPlaylistsBinding
import ru.kpfu.itis.bagaviev.feed.impl.presentation.view.recyclerview.adapter.PlaylistAdapter
import ru.kpfu.itis.bagaviev.theme.recyclerview.decoration.PlaylistItemDecoration
import ru.kpfu.itis.bagaviev.theme.recyclerview.intercator.PlaylistInteractor
import ru.kpfu.itis.bagaviev.theme.recyclerview.model.PlaylistGroupRvModel
import ru.kpfu.itis.bagaviev.theme.recyclerview.viewholder.MusicComponentViewHolder

class PlaylistGroupViewHolder(
    private val viewBinding: ItemPlaylistsBinding,
    private val interactor: PlaylistInteractor
) : MusicComponentViewHolder(viewBinding.root) {

    private val playlistAdapter = PlaylistAdapter(
        viewBinding.root.context, interactor
    )

    init {
        viewBinding.apply {
            rvPlaylists.adapter = playlistAdapter
            rvPlaylists.addItemDecoration(PlaylistItemDecoration(root.context))
        }
    }

    fun bind(playlistGroupRvModel: PlaylistGroupRvModel) {
        playlistAdapter.submitList(playlistGroupRvModel.playlists)
    }
}