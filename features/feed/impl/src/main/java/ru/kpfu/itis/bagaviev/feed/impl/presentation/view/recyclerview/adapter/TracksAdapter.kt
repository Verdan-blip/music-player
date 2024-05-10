package ru.kpfu.itis.bagaviev.feed.impl.presentation.view.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import ru.kpfu.itis.bagaviev.feed.impl.databinding.ItemTrackBinding
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entities.tracks.TrackModel
import ru.kpfu.itis.bagaviev.feed.impl.presentation.view.recyclerview.diffutil.item_callbacks.TracksItemCallback
import ru.kpfu.itis.bagaviev.feed.impl.presentation.view.recyclerview.holder.TrackViewHolder

class TracksAdapter(
    private val context: Context,
    private val interactor: TrackViewHolder.Companion.TrackInteractor
) : ListAdapter<TrackModel, TrackViewHolder>(TracksItemCallback()) {

    private var currentPlayingTrackId: Long? = null

    private var currentPlayingTrackIdIndex: Int? = null

    private var currentProgress: Int = 0

    private var isPlaying: Boolean = false

    fun setCurrentPlayingTrackId(trackId: Long) {
        if (currentPlayingTrackId == trackId)
            return

        currentPlayingTrackIdIndex?.also { oldIndex ->
            notifyItemChanged(oldIndex)
        }

        currentList.indexOfFirst { track ->
            track.id == trackId
        }.also { index ->
            currentPlayingTrackId = trackId
            currentPlayingTrackIdIndex = index
            isPlaying = true
            currentProgress = 0

            notifyItemChanged(index)
        }
    }

    fun updatePlayingProgress(progress: Int) {
        currentProgress = progress

        currentPlayingTrackIdIndex?.also { index ->
            notifyItemChanged(index, true)
        }
    }

    fun play() {
        isPlaying = true

        currentPlayingTrackIdIndex?.also { index ->
            notifyItemChanged(index, isPlaying)
        }
    }

    fun pause() {
        isPlaying = false

        currentPlayingTrackIdIndex?.also { index ->
            notifyItemChanged(index, isPlaying)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrackViewHolder =
        TrackViewHolder(
            ItemTrackBinding.inflate(LayoutInflater.from(context), parent, false),
            interactor
        )

    override fun onBindViewHolder(holder: TrackViewHolder, position: Int) {
        if (currentPlayingTrackIdIndex == position) {
            holder.bind(currentList[position], TrackViewHolder.Companion.TrackState.Playing(
                isPlaying, currentProgress
            ))
        } else {
            holder.bind(currentList[position], TrackViewHolder.Companion.TrackState.Static)
        }
    }

    override fun onBindViewHolder(
        holder: TrackViewHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        if (payloads.isNotEmpty()) {
            if (payloads.first() as? Boolean == true) {
                holder.bind(
                    currentList[position],
                    TrackViewHolder.Companion.TrackState.Playing(
                        isPlaying, currentProgress
                    )
                )
            }
        } else {
            super.onBindViewHolder(holder, position, payloads)
        }
    }
}