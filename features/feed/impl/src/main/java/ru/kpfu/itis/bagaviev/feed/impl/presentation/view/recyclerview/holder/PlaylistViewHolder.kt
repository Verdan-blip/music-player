package ru.kpfu.itis.bagaviev.feed.impl.presentation.view.recyclerview.holder

import coil.load
import ru.kpfu.itis.bagaviev.theme.databinding.ItemPlaylistBinding
import ru.kpfu.itis.bagaviev.theme.recyclerview.intercator.PlaylistInteractor
import ru.kpfu.itis.bagaviev.theme.recyclerview.model.PlaylistRvModel
import ru.kpfu.itis.bagaviev.theme.recyclerview.viewholder.MusicComponentViewHolder

class PlaylistViewHolder(
    private val viewBinding: ItemPlaylistBinding,
    private val interactor: PlaylistInteractor
) : MusicComponentViewHolder(viewBinding.root) {

    private var playlistRvModel: PlaylistRvModel? = null

    init {
        viewBinding.apply {
            root.setOnClickListener {
                playlistRvModel?.apply { interactor.onClick(id) }
            }
            root.setOnLongClickListener {
                playlistRvModel?.apply { interactor.onLongClick(id) }
                true
            }
        }
    }

    fun bind(playlistRvModel: PlaylistRvModel) {
        this.playlistRvModel = playlistRvModel
        viewBinding.apply {
            tvTitle.text = playlistRvModel.title
            ivCover.load(playlistRvModel.coverUri)
        }
    }
}