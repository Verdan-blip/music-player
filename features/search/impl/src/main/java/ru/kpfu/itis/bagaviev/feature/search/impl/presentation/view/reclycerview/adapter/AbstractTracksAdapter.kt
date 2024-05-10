package ru.kpfu.itis.bagaviev.feature.search.impl.presentation.view.reclycerview.adapter

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.entities.tracks.TrackModel
import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.view.reclycerview.diffutils.callback.TracksCallback
import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.view.reclycerview.holder.PlayableInfoViewHolder
import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.view.reclycerview.holder.TrackViewHolder

abstract class AbstractTracksAdapter : RecyclerView.Adapter<PlayableInfoViewHolder>() {

    protected var trackList: List<TrackModel> = listOf()

    protected var isPlaying: Boolean = false
        private set

    protected var playingProgress: Int = 0
        private set

    protected var playingTrackLocalIndex: Int? = null
        private set


    abstract fun onPayload(
        payloadsDecoded: PayloadsDecoded,
        holder: PlayableInfoViewHolder,
        position: Int)

    abstract fun getTrackGlobalPosition(localPosition: Int): Int

    fun play(trackId: Long) {
        playingTrackLocalIndex?.also { oldIndex ->
            notifyItemChanged(getTrackGlobalPosition(oldIndex))
        }
        val trackIndex = trackList.indexOfFirst { trackModel ->
            trackModel.id == trackId
        }
        playingTrackLocalIndex = trackIndex
        notifyItemChanged(
            getTrackGlobalPosition(trackIndex), PAYLOAD_KEY_TRACK_ID to trackId
        )
    }

    fun pause() {
        isPlaying = false
        playingTrackLocalIndex?.also { trackIndex ->
            notifyItemChanged(
                getTrackGlobalPosition(trackIndex),
                PAYLOAD_KEY_TRACK_IS_PLAYING to isPlaying
            )
        }
    }

    fun play() {
        isPlaying = true
        playingTrackLocalIndex?.also { trackIndex ->
            notifyItemChanged(
                getTrackGlobalPosition(trackIndex),
                PAYLOAD_KEY_TRACK_IS_PLAYING to isPlaying
            )
        }
    }

    fun updateProgress(newProgress: Int) {
        playingProgress = newProgress
        playingTrackLocalIndex?.also { trackIndex ->
            notifyItemChanged(
                getTrackGlobalPosition(trackIndex),
                PAYLOAD_KEY_TRACK_PLAYING_PROGRESS to playingProgress
            )
        }
    }

    fun submitTrackList(trackList: List<TrackModel>) {
        val diffResult = DiffUtil.calculateDiff(
            TracksCallback(this.trackList, trackList)
        )
        this.trackList = trackList
        diffResult.dispatchUpdatesTo(this)
    }

    override fun getItemCount(): Int = trackList.size

    override fun onBindViewHolder(
        holder: PlayableInfoViewHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        if (payloads.isNotEmpty() && holder is TrackViewHolder) {
            val pair = payloads.first() as Pair<*, *>
            when (pair.first) {
                PAYLOAD_KEY_TRACK_ID -> {
                    onPayload(
                        PayloadsDecoded.SetNewPlayingTrack(pair.second as Long),
                        holder, position
                    )
                }
                PAYLOAD_KEY_TRACK_IS_PLAYING -> {
                    onPayload(
                        PayloadsDecoded.UpdateIsPlaying(pair.second as Boolean),
                        holder, position
                    )
                }
                PAYLOAD_KEY_TRACK_PLAYING_PROGRESS -> {
                    onPayload(
                        PayloadsDecoded.UpdatePlayingProgress(pair.second as Int),
                        holder, position
                    )
                }
            }
        } else {
            super.onBindViewHolder(holder, position, payloads)
        }
    }

    companion object {

        const val PAYLOAD_KEY_TRACK_ID = "trackId"
        const val PAYLOAD_KEY_TRACK_IS_PLAYING = "isPlaying"
        const val PAYLOAD_KEY_TRACK_PLAYING_PROGRESS = "playingProgress"

        sealed class PayloadsDecoded {

            data class UpdatePlayingProgress(val progress: Int) : PayloadsDecoded()

            data class UpdateIsPlaying(val isPlaying: Boolean) : PayloadsDecoded()

            data class SetNewPlayingTrack(val trackId: Long) : PayloadsDecoded()
        }
    }
}