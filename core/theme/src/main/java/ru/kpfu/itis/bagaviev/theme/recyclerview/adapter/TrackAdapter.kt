package ru.kpfu.itis.bagaviev.theme.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import ru.kpfu.itis.bagaviev.theme.databinding.ItemTrackBinding
import ru.kpfu.itis.bagaviev.theme.recyclerview.intercator.TrackInteractor
import ru.kpfu.itis.bagaviev.theme.recyclerview.model.TrackRvModel
import ru.kpfu.itis.bagaviev.theme.recyclerview.viewholder.MusicComponentViewHolder
import ru.kpfu.itis.bagaviev.theme.recyclerview.viewholder.TrackViewHolder

open class TrackAdapter(
    private val context: Context,
    private val trackInteractor: TrackInteractor
) : PlayableAdapter() {

    override fun onBindPlayableViewHolder(
        holder: MusicComponentViewHolder,
        position: Int,
        payloadType: PayloadType
    ) {
        if (holder is TrackViewHolder) {
            when (payloadType) {
                is PayloadType.RedrawAsStatic -> holder.updateAsStatic()
                is PayloadType.RedrawAsReadyToPlay -> holder.updateAsReadyToPlay()
                is PayloadType.UpdateProgress -> holder.updateProgress(payloadType.progress)
                is PayloadType.UpdateIsPlaying -> holder.updateIsPlaying(payloadType.isPlaying)
            }
        }
    }

    override fun onBindViewHolder(holder: MusicComponentViewHolder, position: Int) {
        if (holder is TrackViewHolder) {
            holder.bind(currentList[position] as TrackRvModel)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicComponentViewHolder =
        TrackViewHolder(
            ItemTrackBinding.inflate(
                LayoutInflater.from(context), parent, false
            ),
            trackInteractor
        )
}