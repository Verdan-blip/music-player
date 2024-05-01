package ru.kpfu.itis.bagaviev.impl.presentation.view.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import ru.kpfu.itis.bagaviev.impl.databinding.ItemPlaylistBinding
import ru.kpfu.itis.bagaviev.impl.presentation.entities.playlists.PlaylistModel
import ru.kpfu.itis.bagaviev.impl.presentation.view.recyclerview.diffutil.PlaylistDiffUtil
import ru.kpfu.itis.bagaviev.impl.presentation.view.recyclerview.holder.playlist.PlaylistViewHolder

class PlaylistAdapter(
    private val context: Context
) : ListAdapter<PlaylistModel, PlaylistViewHolder>(PlaylistDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistViewHolder =
        PlaylistViewHolder(
            ItemPlaylistBinding.inflate(
                LayoutInflater.from(context), parent, false
            )
        )

    override fun onBindViewHolder(holder: PlaylistViewHolder, position: Int) {
        holder.bind(currentList[position])
    }
}