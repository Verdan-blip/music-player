package ru.kpfu.itis.bagaviev.feature.search.impl.presentation.view.reclycerview.diffutils.item_callback

import androidx.recyclerview.widget.DiffUtil
import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.entities.tracks.TrackModel

class TracksItemCallback : DiffUtil.ItemCallback<TrackModel>() {

    override fun areItemsTheSame(oldItem: TrackModel, newItem: TrackModel): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: TrackModel, newItem: TrackModel): Boolean =
        oldItem.id == newItem.id
}