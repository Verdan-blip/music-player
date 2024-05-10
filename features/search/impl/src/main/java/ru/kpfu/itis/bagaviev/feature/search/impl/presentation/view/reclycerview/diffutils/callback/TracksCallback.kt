package ru.kpfu.itis.bagaviev.feature.search.impl.presentation.view.reclycerview.diffutils.callback

import androidx.recyclerview.widget.DiffUtil
import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.entities.tracks.TrackModel

class TracksCallback(
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