package ru.kpfu.itis.bagaviev.feature.search.impl.presentation.view.reclycerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import ru.kpfu.itis.bagaviev.feature.search.impl.databinding.ItemPlaylistsBinding
import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.view.reclycerview.holder.PlaylistGroupViewHolder
import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.view.reclycerview.holder.SubtitleViewHolder
import ru.kpfu.itis.bagaviev.theme.databinding.ItemFeedSubtitleBinding
import ru.kpfu.itis.bagaviev.theme.databinding.ItemTrackBinding
import ru.kpfu.itis.bagaviev.theme.recyclerview.exceptions.UnknownViewTypeException
import ru.kpfu.itis.bagaviev.theme.recyclerview.adapter.TrackAdapter
import ru.kpfu.itis.bagaviev.theme.recyclerview.intercator.PlaylistInteractor
import ru.kpfu.itis.bagaviev.theme.recyclerview.intercator.TrackInteractor
import ru.kpfu.itis.bagaviev.theme.recyclerview.model.PlaylistGroupRvModel
import ru.kpfu.itis.bagaviev.theme.recyclerview.model.PlaylistRvModel
import ru.kpfu.itis.bagaviev.theme.recyclerview.model.SubtitleRvModel
import ru.kpfu.itis.bagaviev.theme.recyclerview.model.TrackRvModel
import ru.kpfu.itis.bagaviev.theme.recyclerview.model.base.MusicComponentRvModel
import ru.kpfu.itis.bagaviev.theme.recyclerview.viewholder.MusicComponentViewHolder
import ru.kpfu.itis.bagaviev.theme.recyclerview.viewholder.TrackViewHolder

class FoundAdapter(
    private val context: Context,
    private val trackInteractor: TrackInteractor,
    private val playlistInteractor: PlaylistInteractor
) : TrackAdapter(context, trackInteractor) {

    override fun getItemViewType(position: Int): Int {
        if (currentList.isEmpty()) return VIEW_TYPE_EMPTY
        return when (currentList[position]) {
            is SubtitleRvModel -> VIEW_TYPE_SUBTITLE
            is PlaylistGroupRvModel -> VIEW_TYPE_PLAYLISTS
            is TrackRvModel -> VIEW_TYPE_TRACK
            else -> throw IllegalStateException("View type can't be assigned from position: $position")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicComponentViewHolder {
        val inflater = LayoutInflater.from(context)
        return when (viewType) {
            VIEW_TYPE_SUBTITLE -> SubtitleViewHolder(
                ItemFeedSubtitleBinding.inflate(
                    inflater, parent, false
                )
            )
            VIEW_TYPE_TRACK -> {
                TrackViewHolder(
                    ItemTrackBinding.inflate(
                        inflater, parent, false
                    ), trackInteractor
                )
            }
            VIEW_TYPE_PLAYLISTS -> PlaylistGroupViewHolder(
                ItemPlaylistsBinding.inflate(
                    inflater, parent, false
                ), playlistInteractor
            )
            else -> throw UnknownViewTypeException(viewType)
        }
    }

    override fun onBindViewHolder(holder: MusicComponentViewHolder, position: Int) {
        when (holder) {
            is SubtitleViewHolder -> {
                holder.bind(currentList[position] as SubtitleRvModel)
            }
            is TrackViewHolder -> {
                holder.bind(currentList[position] as TrackRvModel)
            }
            is PlaylistGroupViewHolder -> {
                holder.bind(currentList[position] as PlaylistGroupRvModel)
            }
        }
    }

    fun submitData(
        tracks: List<TrackRvModel>,
        playlists: List<PlaylistRvModel>,
        commitCallback: () -> Unit = { }
    ) {
        val newList = mutableListOf<MusicComponentRvModel>()
        newList.add(SubtitleRvModel(
            SUBTITLE_TYPE_FOUND,
            "Найдено: ${tracks.count()} + ${playlists.count()}")
        )
        newList.addAll(tracks)
        newList.add(PlaylistGroupRvModel(0, playlists))
        super.submitList(newList, commitCallback)
    }


    companion object {
        const val SUBTITLE_TYPE_FOUND = 0

        const val VIEW_TYPE_SUBTITLE = 0
        const val VIEW_TYPE_TRACK = 1
        const val VIEW_TYPE_PLAYLISTS = 2
        const val VIEW_TYPE_EMPTY = 3
    }
}