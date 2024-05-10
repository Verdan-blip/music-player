package ru.kpfu.itis.bagaviev.feature.search.impl.presentation.view.reclycerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import ru.kpfu.itis.bagaviev.feature.search.impl.R
import ru.kpfu.itis.bagaviev.feature.search.impl.databinding.ItemPlaylistsBinding
import ru.kpfu.itis.bagaviev.feature.search.impl.databinding.ItemSearchSubtitleBinding
import ru.kpfu.itis.bagaviev.feature.search.impl.databinding.ItemTrackBinding
import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.view.reclycerview.holder.PlaylistsViewHolder
import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.view.reclycerview.holder.SubtitleViewHolder
import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.entities.playlists.PlaylistModel
import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.view.reclycerview.holder.PlayableInfoViewHolder
import ru.kpfu.itis.bagaviev.feed.impl.presentation.view.common.recyclerview.holder.PlaylistViewHolder
import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.view.reclycerview.holder.TrackViewHolder

class FoundItemsAdapter(
    private val context: Context,
    private val tracksInteractor: TrackViewHolder.Companion.TrackInteractor,
    private val playlistsInteractor: PlaylistViewHolder.Companion.PlaylistInteractor
) : AbstractTracksAdapter() {

    private var playlistList: List<PlaylistModel> = listOf()

    fun submitPlaylistList(playlistList: List<PlaylistModel>) {
        this.playlistList = playlistList
        notifyItemChanged(getPlaylistsFoundPosition())
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
            0 -> ITEM_VIEW_TYPE_SEARCH_INFO_SUBTITLE
            in 1..trackList.size + 1 -> ITEM_VIEW_TYPE_TRACK
            else -> ITEM_VIEW_TYPE_PLAYLISTS
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayableInfoViewHolder = run {
        val inflater = LayoutInflater.from(context)
        when (viewType) {
            ITEM_VIEW_TYPE_SEARCH_INFO_SUBTITLE -> SubtitleViewHolder(
                ItemSearchSubtitleBinding.inflate(inflater)
            )
            ITEM_VIEW_TYPE_TRACK -> TrackViewHolder(
                ItemTrackBinding.inflate(inflater),
                tracksInteractor
            )
            ITEM_VIEW_TYPE_PLAYLISTS -> PlaylistsViewHolder(
                ItemPlaylistsBinding.inflate(inflater),
                playlistsInteractor
            )
            else -> throw IllegalStateException("Unknown viewType: $viewType")
        }
    }

    override fun onBindViewHolder(holder: PlayableInfoViewHolder, position: Int) {
        when (holder) {
            is SubtitleViewHolder -> {
                holder.bind(
                    context.resources.getString(
                        R.string.search_fragment_found_items_count,
                        trackList.size, playlistList.size
                    )
                )
            }
            is TrackViewHolder -> {
                holder.bind(
                    trackList[position - 1],
                    if (isPlaying)
                        TrackViewHolder.Companion.TrackState.Playing(isPlaying, playingProgress)
                    else
                        TrackViewHolder.Companion.TrackState.Static
                )
            }
            is PlaylistsViewHolder -> {
                holder.bind(playlistList)
            }
        }
    }

    override fun getItemCount(): Int = 1 + super.getItemCount() + 1

    private fun getPlaylistsFoundPosition(): Int = 1 + super.getItemCount()

    companion object {

        const val ITEM_VIEW_TYPE_SEARCH_INFO_SUBTITLE = 0
        const val ITEM_VIEW_TYPE_TRACK = 1
        const val ITEM_VIEW_TYPE_PLAYLISTS = 2
    }
}