package ru.kpfu.itis.bagaviev.feature.search.impl.presentation.view.reclycerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import ru.kpfu.itis.bagaviev.feature.search.impl.databinding.ItemPlaylistBinding
import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.view.reclycerview.diffutils.item_callback.PlaylistItemCallback
import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.entities.playlists.PlaylistModel
import ru.kpfu.itis.bagaviev.feed.impl.presentation.view.common.recyclerview.holder.PlaylistViewHolder

class PlaylistsAdapter(
    private val context: Context,
    private val interactor: PlaylistViewHolder.Companion.PlaylistInteractor
) : ListAdapter<PlaylistModel, PlaylistViewHolder>(PlaylistItemCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistViewHolder =
        PlaylistViewHolder(
            ItemPlaylistBinding.inflate(
                LayoutInflater.from(context), parent, false
            ),
            interactor
        )

    override fun onBindViewHolder(holder: PlaylistViewHolder, position: Int) {
        holder.bind(currentList[position])
    }
}