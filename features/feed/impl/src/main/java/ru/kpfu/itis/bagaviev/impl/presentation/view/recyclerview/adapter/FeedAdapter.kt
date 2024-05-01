package ru.kpfu.itis.bagaviev.impl.presentation.view.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ru.kpfu.itis.bagaviev.impl.R
import ru.kpfu.itis.bagaviev.impl.databinding.ItemFeedSubtitleBinding
import ru.kpfu.itis.bagaviev.impl.databinding.ItemPlayingTrackBinding
import ru.kpfu.itis.bagaviev.impl.databinding.ItemPlaylistsBinding
import ru.kpfu.itis.bagaviev.impl.databinding.ItemTrackBinding
import ru.kpfu.itis.bagaviev.impl.presentation.entities.playlists.PlaylistModel
import ru.kpfu.itis.bagaviev.impl.presentation.entities.tracks.TrackModel
import ru.kpfu.itis.bagaviev.impl.presentation.view.recyclerview.diffutil.TracksDiffUtil
import ru.kpfu.itis.bagaviev.impl.presentation.view.recyclerview.holder.feed.FeedSubtitleViewHolder
import ru.kpfu.itis.bagaviev.impl.presentation.view.recyclerview.holder.FeedViewHolder
import ru.kpfu.itis.bagaviev.impl.presentation.view.recyclerview.holder.track.PlayingTrackViewHolder
import ru.kpfu.itis.bagaviev.impl.presentation.view.recyclerview.holder.feed.PlaylistsViewHolder
import ru.kpfu.itis.bagaviev.impl.presentation.view.recyclerview.holder.track.TrackViewHolder
import ru.kpfu.itis.common.util.extensions.secondOrNull

class FeedAdapter(
    private var context: Context,
    private val interactor: PlayingTrackViewHolder.Companion.PlayingTrackInteractor
) : RecyclerView.Adapter<FeedViewHolder>() {

    private var trackList: List<TrackModel> = listOf()

    private var playlistList: List<PlaylistModel> = listOf()

    private var currentPlayingId: Long? = null

    private var currentPlayingIdIndex: Int? = null

    private var isPlaying: Boolean = false

    private var currentProgress: Int = 0

    fun setPlayingTrack(trackId: Long) {
        currentPlayingId = trackId
        currentPlayingIdIndex = trackList.indexOfFirst {
            track -> track.id == trackId
        }.also { index ->
            currentProgress = 0
            isPlaying = true

            notifyItemChanged(
                trackPositionAsFeedPosition(index), listOf(isPlaying, currentProgress)
            )
        }
    }

    fun setPlayingPlaylist(playlistId: Long) {

    }

    fun updatePlayingProgress(progress: Int) {
        currentProgress = progress

        currentPlayingIdIndex?.also { index ->
            notifyItemChanged(trackPositionAsFeedPosition(index), listOf(isPlaying, progress))
        }
    }

    fun play() {
        isPlaying = true

        currentPlayingIdIndex?.also { index ->
            notifyItemChanged(trackPositionAsFeedPosition(index), listOf(isPlaying, currentProgress))
        }
    }

    fun pause() {
        isPlaying = false

        currentPlayingIdIndex?.also { index ->
            notifyItemChanged(trackPositionAsFeedPosition(index), listOf(isPlaying, currentProgress))
        }
    }

    fun submitTrackList(trackList: List<TrackModel>) {
        val diffResult = DiffUtil.calculateDiff(
            TracksDiffUtil(oldList = this.trackList, newList = trackList)
        )
        this.trackList = trackList
        diffResult.dispatchUpdatesTo(this)
        notifyItemChanged(getSubtitleFeedPosition(Subtitle.TRACK_CHARTS))
    }

    fun submitPlaylistList(playlistList: List<PlaylistModel>) {
        this.playlistList = playlistList
        notifyItemChanged(getPlaylistsFeedPosition())
        notifyItemChanged(getSubtitleFeedPosition(Subtitle.POPULAR_PLAYLISTS))
    }

    override fun getItemViewType(position: Int): Int =
        if (currentPlayingIdIndex == feedPositionAsTrackPosition(position)) {
            ITEM_VIEW_TYPE_PLAYING_TRACK
        } else when (position) {
            getSubtitleFeedPosition(Subtitle.TRACK_CHARTS),
            getSubtitleFeedPosition(Subtitle.POPULAR_PLAYLISTS) -> ITEM_VIEW_TYPE_SUBTITLE
            in 1..<getSubtitleFeedPosition(Subtitle.POPULAR_PLAYLISTS) -> ITEM_VIEW_TYPE_TRACK
            else -> ITEM_VIEW_TYPE_PLAYLISTS
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder =
        when (viewType) {
            ITEM_VIEW_TYPE_SUBTITLE -> FeedSubtitleViewHolder(
                ItemFeedSubtitleBinding.inflate(LayoutInflater.from(context), parent, false)
            )
            ITEM_VIEW_TYPE_TRACK -> TrackViewHolder(
                ItemTrackBinding.inflate(LayoutInflater.from(context), parent, false),
                interactor
            )
            ITEM_VIEW_TYPE_PLAYING_TRACK -> PlayingTrackViewHolder(
                ItemPlayingTrackBinding.inflate(LayoutInflater.from(context), parent, false),
                interactor
            )
            ITEM_VIEW_TYPE_PLAYLISTS -> PlaylistsViewHolder(
                ItemPlaylistsBinding.inflate(LayoutInflater.from(context), parent, false)
            )
            else -> throw IllegalStateException("Unknown view type $viewType")
        }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        when (holder) {
            is FeedSubtitleViewHolder -> holder.bind(
                if (position == 0)
                    context.resources.getString(
                        R.string.feed_fragment_top_charts, trackList.size
                    )
                else
                    context.resources.getString(
                        R.string.feed_fragment_popular_playlists, playlistList.size
                    )
            )
            is TrackViewHolder -> holder.bind(
                trackList[feedPositionAsTrackPosition(position)]
            )
            is PlaylistsViewHolder -> holder.bind(
                playlistList
            )
        }
    }

    override fun onBindViewHolder(
        holder: FeedViewHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        if (payloads.isNotEmpty()) {
            val params = payloads.first() as List<Any?>
            if (holder is PlayingTrackViewHolder) {
                holder.bind(
                    trackList[feedPositionAsTrackPosition(position)],
                    isPlaying, currentProgress
                )
            }
        } else {
            super.onBindViewHolder(holder, position, payloads)
        }
    }

    override fun getItemCount(): Int =
        1 + trackList.size + 1 + 1

    private fun trackPositionAsFeedPosition(trackPos: Int): Int = trackPos + 1

    private fun feedPositionAsTrackPosition(globalPos: Int): Int = globalPos - 1

    private fun getPlaylistsFeedPosition(): Int = 1 + trackList.size + 1

    private fun getSubtitleFeedPosition(subtitle: Subtitle): Int =
        when (subtitle) {
            Subtitle.TRACK_CHARTS -> 0
            Subtitle.POPULAR_PLAYLISTS -> 1 + trackList.size
        }

    private fun getTracksFeedPosition(): Int = 1

    fun isPlaylistsFeedPosition(feedPosition: Int): Boolean =
        feedPosition == getPlaylistsFeedPosition()

    fun isTracksFeedPosition(feedPosition: Int): Boolean =
        feedPosition == getTracksFeedPosition()

    fun isSubtitleFeedPosition(feedPosition: Int): Boolean =
        feedPosition == getSubtitleFeedPosition(Subtitle.TRACK_CHARTS) ||
                feedPosition == getSubtitleFeedPosition(Subtitle.POPULAR_PLAYLISTS)

    fun isTrackFeedPosition(feedPosition: Int): Boolean =
        feedPosition in getTracksFeedPosition()..<getSubtitleFeedPosition(
            Subtitle.POPULAR_PLAYLISTS
        )


    companion object {

        const val ITEM_VIEW_TYPE_SUBTITLE = 0
        const val ITEM_VIEW_TYPE_TRACK = 1
        const val ITEM_VIEW_TYPE_PLAYING_TRACK = 2
        const val ITEM_VIEW_TYPE_PLAYLISTS = 3

        enum class Subtitle { TRACK_CHARTS, POPULAR_PLAYLISTS }
    }
}