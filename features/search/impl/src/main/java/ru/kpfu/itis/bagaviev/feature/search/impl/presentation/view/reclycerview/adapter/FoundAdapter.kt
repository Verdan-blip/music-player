package ru.kpfu.itis.bagaviev.feature.search.impl.presentation.view.reclycerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import ru.kpfu.itis.bagaviev.feature.search.impl.R
import ru.kpfu.itis.bagaviev.feature.search.impl.databinding.ItemPlaylistsBinding
import ru.kpfu.itis.bagaviev.feature.search.impl.databinding.ItemSearchSubtitleBinding
import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.view.reclycerview.holder.PlaylistsViewHolder
import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.view.reclycerview.holder.SubtitleViewHolder
import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.entities.playlists.PlaylistModel
import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.view.reclycerview.mappers.toPlaylistItem
import ru.kpfu.itis.bagaviev.theme.databinding.ItemTrackBinding
import ru.kpfu.itis.bagaviev.theme.recyclerview.adapter.TrackAdapter
import ru.kpfu.itis.bagaviev.theme.recyclerview.interactor.PlaylistInteractor
import ru.kpfu.itis.bagaviev.theme.recyclerview.interactor.TrackInteractor
import ru.kpfu.itis.bagaviev.theme.recyclerview.viewholder.PlayableViewHolder
import ru.kpfu.itis.bagaviev.theme.recyclerview.viewholder.TrackViewHolder

class FoundAdapter(
    private val context: Context,
    private val tracksInteractor: TrackInteractor,
    private val playlistsInteractor: PlaylistInteractor
) : TrackAdapter(context, tracksInteractor) {

    private var playlistList: List<PlaylistModel> = listOf()

    fun submitPlaylistList(playlistList: List<PlaylistModel>) {
        this.playlistList = playlistList
        notifyItemChanged(getPlaylistsFoundPosition())
    }


    override fun getTrackPositionInAdapter(trackIndex: Int): Int =
        trackIndex + 1

    override fun getTrackIndexFromAdapter(position: Int): Int =
        position - 1

    override fun getItemViewType(position: Int): Int =
        when (position) {
            0 -> ITEM_VIEW_TYPE_SEARCH_INFO_SUBTITLE
            getPlaylistsFoundPosition() -> ITEM_VIEW_TYPE_PLAYLISTS
            else -> ITEM_VIEW_TYPE_TRACK
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayableViewHolder {
        val inflater = LayoutInflater.from(context)
        return when (viewType) {
            ITEM_VIEW_TYPE_SEARCH_INFO_SUBTITLE -> SubtitleViewHolder(
                ItemSearchSubtitleBinding.inflate(inflater, parent, false)
            )
            ITEM_VIEW_TYPE_TRACK -> TrackViewHolder(
                ItemTrackBinding.inflate(inflater, parent, false),
                tracksInteractor
            )
            ITEM_VIEW_TYPE_PLAYLISTS -> PlaylistsViewHolder(
                ItemPlaylistsBinding.inflate(inflater, parent, false),
                playlistsInteractor
            )
            else ->
                throw IllegalStateException("Unknown viewType: $viewType")
        }
    }

    override fun onBindViewHolder(holder: PlayableViewHolder, position: Int) {
        when (holder) {
            is SubtitleViewHolder -> {
                holder.bind(
                    context.resources.getString(
                        R.string.search_fragment_found_items_count,
                        currentList.size, playlistList.size
                    )
                )
            }
            is TrackViewHolder ->
                super.onBindViewHolder(holder, position)
            is PlaylistsViewHolder -> {
                holder.bind(playlistList.map { playlistModel ->
                    playlistModel.toPlaylistItem()
                })
            }
        }
    }

    override fun getItemCount(): Int = 1 + super.getItemCount() + 1

    fun isTracksFoundPosition(position: Int): Boolean =
        position == 1

    fun isTrackFoundPosition(position: Int): Boolean =
        position in 1..super.getItemCount()

    fun isPlaylistsFoundPosition(position: Int): Boolean =
        position == 1 + super.getItemCount()

    fun isSubtitleFoundPosition(position: Int): Boolean =
        position == 0

    private fun getPlaylistsFoundPosition(): Int = 1 + super.getItemCount()

    companion object {

        const val ITEM_VIEW_TYPE_SEARCH_INFO_SUBTITLE = 0
        const val ITEM_VIEW_TYPE_TRACK = 1
        const val ITEM_VIEW_TYPE_PLAYLISTS = 2
    }
}