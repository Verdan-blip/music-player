package ru.kpfu.itis.bagaviev.theme.recyclerview.viewholder

import androidx.recyclerview.widget.RecyclerView
import coil.load
import ru.kpfu.itis.bagaviev.theme.databinding.ItemPlaylistBinding
import ru.kpfu.itis.bagaviev.theme.recyclerview.interactor.PlaylistInteractor
import ru.kpfu.itis.bagaviev.theme.recyclerview.model.PlaylistItem

class PlaylistViewHolder(
    private val viewBinding: ItemPlaylistBinding,
    private val interactor: PlaylistInteractor
) : RecyclerView.ViewHolder(viewBinding.root) {

    private var playlistItem: PlaylistItem? = null

    init {
        viewBinding.apply {
            root.setOnClickListener {
                playlistItem?.apply { interactor.onClick(id) }
            }
            root.setOnLongClickListener {
                playlistItem?.apply { interactor.onLongClick(id) }
                true
            }
        }
    }

    fun bind(playlistItem: PlaylistItem) {
        this.playlistItem = playlistItem
        viewBinding.apply {
            tvTitle.text = playlistItem.title
            ivCover.load(playlistItem.coverUri)
        }
    }
}