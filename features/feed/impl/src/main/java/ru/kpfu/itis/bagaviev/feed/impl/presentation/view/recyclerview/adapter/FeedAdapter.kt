package ru.kpfu.itis.bagaviev.feed.impl.presentation.view.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import ru.kpfu.itis.bagaviev.feed.impl.R
import ru.kpfu.itis.bagaviev.feed.impl.databinding.ItemFeedSubtitleBinding
import ru.kpfu.itis.bagaviev.feed.impl.databinding.ItemPlaylistsBinding
import ru.kpfu.itis.bagaviev.feed.impl.databinding.ItemTrackBinding
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entities.playlists.PlaylistModel
import ru.kpfu.itis.bagaviev.feed.impl.presentation.view.recyclerview.holder.PlayableInfoViewHolder
import ru.kpfu.itis.bagaviev.feed.impl.presentation.view.recyclerview.holder.SubtitleViewHolder
import ru.kpfu.itis.bagaviev.feed.impl.presentation.view.recyclerview.holder.PlaylistViewHolder
import ru.kpfu.itis.bagaviev.feed.impl.presentation.view.recyclerview.holder.PlaylistsViewHolder
import ru.kpfu.itis.bagaviev.feed.impl.presentation.view.recyclerview.holder.TrackViewHolder

class FeedAdapter(
    private var context: Context,
    private val trackInteractor: TrackViewHolder.Companion.TrackInteractor,
    private val playlistInteractor: PlaylistViewHolder.Companion.PlaylistInteractor
) : AbstractTracksAdapter() {

    private var playlistList: List<PlaylistModel> = listOf()

    fun submitPlaylistList(playlistList: List<PlaylistModel>) {
        this.playlistList = playlistList
        notifyItemChanged(getPlaylistsFeedPosition())
    }

    override fun onPayload(
        payloadsDecoded: AbstractTracksAdapter.Companion.PayloadsDecoded,
        holder: PlayableInfoViewHolder,
        position: Int
    ) {
        if (holder is TrackViewHolder) {
            when (payloadsDecoded) {
                is AbstractTracksAdapter.Companion.PayloadsDecoded.UpdateIsPlaying -> {
                    holder.rebind(payloadsDecoded.isPlaying)
                }
                is AbstractTracksAdapter.Companion.PayloadsDecoded.UpdatePlayingProgress -> {
                    holder.rebind(payloadsDecoded.progress)
                }
                is AbstractTracksAdapter.Companion.PayloadsDecoded.SetNewPlayingTrack -> {
                    holder.bind(
                        trackList[position - 1],
                        TrackViewHolder.Companion.TrackState.Playing(
                            isPlaying = true, progress = 0
                        )
                    )
                }
            }
        }
    }

    override fun getTrackGlobalPosition(localPosition: Int): Int =
        localPosition + 1

    override fun getItemViewType(position: Int): Int =
        when (position) {
            getSubtitleFeedPosition(Subtitle.TRACK_CHARTS),
            getSubtitleFeedPosition(Subtitle.POPULAR_PLAYLISTS) -> ITEM_VIEW_TYPE_SUBTITLE
            in 1..<getSubtitleFeedPosition(Subtitle.POPULAR_PLAYLISTS) -> ITEM_VIEW_TYPE_TRACK
            else -> ITEM_VIEW_TYPE_PLAYLISTS
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayableInfoViewHolder = run {
        val inflater = LayoutInflater.from(context)
        when (viewType) {
            ITEM_VIEW_TYPE_SUBTITLE -> SubtitleViewHolder(
                ItemFeedSubtitleBinding.inflate(inflater, parent, false)
            )
            ITEM_VIEW_TYPE_TRACK -> TrackViewHolder(
                ItemTrackBinding.inflate(inflater, parent, false),
                trackInteractor
            )
            ITEM_VIEW_TYPE_PLAYLISTS -> PlaylistsViewHolder(
                ItemPlaylistsBinding.inflate(inflater, parent, false),
                playlistInteractor
            )
            else -> throw IllegalStateException("Unknown view type $viewType")
        }
    }

    override fun onBindViewHolder(holder: PlayableInfoViewHolder, position: Int) {
        when (holder) {
            is SubtitleViewHolder -> holder.bind(
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
                trackList[feedPositionAsTrackPosition(position)],
                if (feedPositionAsTrackPosition(position) == playingTrackLocalIndex) {
                    TrackViewHolder.Companion.TrackState.Playing(isPlaying, playingProgress)
                } else {
                        TrackViewHolder.Companion.TrackState.Static
                }
            )
            is PlaylistsViewHolder -> holder.bind(
                playlistList
            )
        }
    }

    override fun getItemCount(): Int =
        1 + trackList.size + 1 + 1

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
        const val ITEM_VIEW_TYPE_PLAYLISTS = 2

        enum class Subtitle { TRACK_CHARTS, POPULAR_PLAYLISTS }
    }
}