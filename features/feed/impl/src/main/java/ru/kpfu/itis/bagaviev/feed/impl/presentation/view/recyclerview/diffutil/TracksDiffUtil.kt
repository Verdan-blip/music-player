package ru.kpfu.itis.bagaviev.feed.impl.presentation.view.recyclerview.diffutil

import androidx.recyclerview.widget.DiffUtil
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entities.tracks.TrackModel

class TracksDiffUtil(
    private val oldList: List<TrackModel>,
    private val newList: List<TrackModel>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int =
        oldList.size

    override fun getNewListSize(): Int =
        newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition].id == newList[newItemPosition].id

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition] == newList[newItemPosition]
}