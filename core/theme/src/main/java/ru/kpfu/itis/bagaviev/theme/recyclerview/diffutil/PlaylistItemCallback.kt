package ru.kpfu.itis.bagaviev.theme.recyclerview.diffutil

import androidx.recyclerview.widget.DiffUtil
import ru.kpfu.itis.bagaviev.theme.recyclerview.model.PlaylistItem

class PlaylistItemCallback : DiffUtil.ItemCallback<PlaylistItem>() {

    override fun areItemsTheSame(oldItem: PlaylistItem, newItem: PlaylistItem): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: PlaylistItem, newItem: PlaylistItem): Boolean =
        oldItem == newItem
}