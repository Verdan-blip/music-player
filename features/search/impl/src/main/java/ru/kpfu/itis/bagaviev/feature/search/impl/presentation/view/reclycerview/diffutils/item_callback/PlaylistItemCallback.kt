package ru.kpfu.itis.bagaviev.feature.search.impl.presentation.view.reclycerview.diffutils.item_callback

import androidx.recyclerview.widget.DiffUtil
import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.entities.playlists.PlaylistModel

class PlaylistItemCallback : DiffUtil.ItemCallback<PlaylistModel>() {

    override fun areItemsTheSame(oldItem: PlaylistModel, newItem: PlaylistModel): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: PlaylistModel, newItem: PlaylistModel): Boolean =
        oldItem == newItem
}