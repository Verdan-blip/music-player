package ru.kpfu.itis.bagaviev.impl.presentation.view.recyclerview.diffutil

import androidx.recyclerview.widget.DiffUtil
import ru.kpfu.itis.bagaviev.impl.presentation.entities.playlists.PlaylistModel

class PlaylistDiffUtil : DiffUtil.ItemCallback<PlaylistModel>() {

    override fun areItemsTheSame(oldItem: PlaylistModel, newItem: PlaylistModel): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: PlaylistModel, newItem: PlaylistModel): Boolean =
        oldItem == newItem
}