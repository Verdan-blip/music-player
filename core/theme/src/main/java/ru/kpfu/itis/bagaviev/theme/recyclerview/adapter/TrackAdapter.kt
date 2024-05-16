package ru.kpfu.itis.bagaviev.theme.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import ru.kpfu.itis.bagaviev.theme.databinding.ItemTrackBinding
import ru.kpfu.itis.bagaviev.theme.recyclerview.diffutil.TrackItemCallback
import ru.kpfu.itis.bagaviev.theme.recyclerview.interactor.TrackInteractor
import ru.kpfu.itis.bagaviev.theme.recyclerview.model.TrackItem
import ru.kpfu.itis.bagaviev.theme.recyclerview.model.TrackState
import ru.kpfu.itis.bagaviev.theme.recyclerview.viewholder.PlayableViewHolder
import ru.kpfu.itis.bagaviev.theme.recyclerview.viewholder.TrackViewHolder

open class TrackAdapter(
    private val context: Context,
    private val trackInteractor: TrackInteractor
) : ListAdapter<TrackItem, PlayableViewHolder>(TrackItemCallback()) {

    protected var playingTrackIndex: Int? = null

    protected var progress: Int = 0

    protected var isPlaying: Boolean = false

    open fun getTrackPositionInAdapter(trackIndex: Int): Int = trackIndex

    open fun getTrackIndexFromAdapter(position: Int): Int = position

    fun markAsPlayable(trackId: Long) {
        val index = currentList.indexOfFirst { track -> track.id == trackId }

        if (index == -1)
            return

        playingTrackIndex?.also { oldIndex ->
            if (oldIndex != index) {
                notifyItemChanged(
                    getTrackPositionInAdapter(oldIndex),
                    TrackState.Static
                )
            }
        }

        playingTrackIndex = index

        notifyItemChanged(
            getTrackPositionInAdapter(index),
            if (isPlaying)
                TrackState.MarkedAsPlaying(progress = progress)
            else
                TrackState.MarkedAsPaused(progress = progress)
        )
    }

    fun play() {
        isPlaying = true
        playingTrackIndex?.also { index ->
            notifyItemChanged(
                getTrackPositionInAdapter(index),
                TrackState.MarkedAsPlaying(progress = progress)
            )
        }
    }

    fun pause() {
        isPlaying = false
        playingTrackIndex?.also { index ->
            notifyItemChanged(
                getTrackPositionInAdapter(index),
                TrackState.MarkedAsPaused(progress = progress)
            )
        }
    }

    fun updatePlayingProgress(progress: Int) {
        this.progress = progress
        playingTrackIndex?.also { index ->
            notifyItemChanged(
                getTrackPositionInAdapter(index),
                TrackState.MarkedAsPlaying(progress)
            )
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayableViewHolder =
        TrackViewHolder(
            ItemTrackBinding.inflate(
                LayoutInflater.from(context), parent, false
            ), trackInteractor
        )

    override fun onBindViewHolder(holder: PlayableViewHolder, position: Int) {
        when (holder) {
            is TrackViewHolder -> {
                val trackIndex = getTrackIndexFromAdapter(position)
                holder.bind(
                    currentList[trackIndex],
                    if (trackIndex == playingTrackIndex)
                        if (isPlaying)
                            TrackState.MarkedAsPlaying(progress)
                        else
                            TrackState.MarkedAsPaused(progress)
                    else
                        TrackState.Static
                )
            }
        }
    }

    override fun onBindViewHolder(
        holder: PlayableViewHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        if (payloads.isNotEmpty()) {
            if (holder is TrackViewHolder) {
                val state = payloads.first() as TrackState
                holder.bindState(state)
            }
        } else {
            super.onBindViewHolder(holder, position, payloads)
        }
    }
}