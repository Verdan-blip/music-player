package ru.kpfu.itis.bagaviev.feed.impl.presentation.view.recyclerview.diffutil

import androidx.recyclerview.widget.DiffUtil
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entities.tracks.TrackModel

class TracksItemCallback : DiffUtil.ItemCallback<TrackModel>() {

    override fun areItemsTheSame(oldItem: TrackModel, newItem: TrackModel): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: TrackModel, newItem: TrackModel): Boolean =
        oldItem.id == newItem.id
}