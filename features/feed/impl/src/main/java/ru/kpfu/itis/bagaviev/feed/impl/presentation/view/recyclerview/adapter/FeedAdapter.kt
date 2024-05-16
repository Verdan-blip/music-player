package ru.kpfu.itis.bagaviev.feed.impl.presentation.view.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import ru.kpfu.itis.bagaviev.feed.impl.R
import ru.kpfu.itis.bagaviev.feed.impl.databinding.ItemFeedSubtitleBinding
import ru.kpfu.itis.bagaviev.feed.impl.databinding.ItemPlaylistsBinding
import ru.kpfu.itis.bagaviev.feed.impl.presentation.view.recyclerview.holder.PlaylistsViewHolder
import ru.kpfu.itis.bagaviev.feed.impl.presentation.view.recyclerview.holder.SubtitleViewHolder
import ru.kpfu.itis.bagaviev.theme.recyclerview.adapter.TrackAdapter
import ru.kpfu.itis.bagaviev.theme.recyclerview.interactor.PlaylistInteractor
import ru.kpfu.itis.bagaviev.theme.recyclerview.interactor.TrackInteractor
import ru.kpfu.itis.bagaviev.theme.recyclerview.model.PlaylistItem
import ru.kpfu.itis.bagaviev.theme.recyclerview.viewholder.PlayableViewHolder
import ru.kpfu.itis.bagaviev.theme.recyclerview.viewholder.TrackViewHolder

class FeedAdapter(
    private var context: Context,
    private val trackInteractor: TrackInteractor,
    private val playlistInteractor: PlaylistInteractor
) : TrackAdapter(context, trackInteractor) {

    private var playlistList: List<PlaylistItem> = listOf()

    fun submitPlaylistList(playlistList: List<PlaylistItem>) {
        this.playlistList = playlistList
        notifyItemChanged(getPlaylistsFeedPosition())
        notifyItemChanged(getSubtitleFeedPosition(Subtitle.POPULAR_PLAYLISTS))
    }

    override fun getTrackPositionInAdapter(trackIndex: Int): Int =
        trackIndex + 1

    override fun getTrackIndexFromAdapter(position: Int): Int =
        position - 1

    override fun getItemViewType(position: Int): Int =
        when (position) {
            getSubtitleFeedPosition(Subtitle.TRACK_CHARTS),
            getSubtitleFeedPosition(Subtitle.POPULAR_PLAYLISTS) -> ITEM_VIEW_TYPE_SUBTITLE
            in 1..<getSubtitleFeedPosition(Subtitle.POPULAR_PLAYLISTS) -> ITEM_VIEW_TYPE_TRACK
            else -> ITEM_VIEW_TYPE_PLAYLISTS
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayableViewHolder {
        val inflater = LayoutInflater.from(context)
        return when (viewType) {
            ITEM_VIEW_TYPE_SUBTITLE -> SubtitleViewHolder(
                ItemFeedSubtitleBinding.inflate(inflater, parent, false)
            )
            ITEM_VIEW_TYPE_TRACK ->
                super.onCreateViewHolder(parent, viewType)
            ITEM_VIEW_TYPE_PLAYLISTS -> PlaylistsViewHolder(
                ItemPlaylistsBinding.inflate(inflater, parent, false),
                playlistInteractor
            )
            else -> throw IllegalStateException("Unknown view type $viewType")
        }
    }

    override fun onBindViewHolder(holder: PlayableViewHolder, position: Int) {
        when (holder) {
            is SubtitleViewHolder -> holder.bind(
                if (position == 0)
                    context.resources.getString(
                        R.string.feed_fragment_top_charts, currentList.size
                    )
                else
                    context.resources.getString(
                        R.string.feed_fragment_popular_playlists, playlistList.size
                    )
            )
            is TrackViewHolder ->
                super.onBindViewHolder(holder, position)
            is PlaylistsViewHolder ->
                holder.bind(playlistList)
        }
    }

    override fun getItemCount(): Int =
        1 + currentList.size + 1 + 1

    private fun getPlaylistsFeedPosition(): Int = 1 + currentList.size + 1

    private fun getSubtitleFeedPosition(subtitle: Subtitle): Int =
        when (subtitle) {
            Subtitle.TRACK_CHARTS -> 0
            Subtitle.POPULAR_PLAYLISTS -> 1 + currentList.size
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