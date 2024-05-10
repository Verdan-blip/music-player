package ru.kpfu.itis.bagaviev.feed.impl.presentation.view.recyclerview.diffutil.item_callbacks

import androidx.recyclerview.widget.DiffUtil
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entities.playlists.PlaylistModel

class PlaylistItemCallback : DiffUtil.ItemCallback<PlaylistModel>() {

    override fun areItemsTheSame(oldItem: PlaylistModel, newItem: PlaylistModel): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: PlaylistModel, newItem: PlaylistModel): Boolean =
        oldItem == newItem
}