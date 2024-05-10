package ru.kpfu.itis.bagaviev.feature.search.impl.presentation.view.reclycerview.diffutils.callback

import androidx.recyclerview.widget.DiffUtil
import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.entities.playlists.PlaylistModel

class PlaylistsCallback(
    private val oldList: List<PlaylistModel>,
    private val newList: List<PlaylistModel>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition].id == newList[newItemPosition].id

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition] == newList[newItemPosition]
}