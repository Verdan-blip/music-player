package ru.kpfu.itis.bagaviev.theme.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import ru.kpfu.itis.bagaviev.theme.databinding.ItemPlaylistBinding
import ru.kpfu.itis.bagaviev.theme.recyclerview.diffutil.PlaylistItemCallback
import ru.kpfu.itis.bagaviev.theme.recyclerview.interactor.PlaylistInteractor
import ru.kpfu.itis.bagaviev.theme.recyclerview.model.PlaylistItem
import ru.kpfu.itis.bagaviev.theme.recyclerview.viewholder.PlaylistViewHolder

class PlaylistAdapter(
    private val context: Context,
    private val playlistInteractor: PlaylistInteractor
) : ListAdapter<PlaylistItem, PlaylistViewHolder>(PlaylistItemCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistViewHolder =
        PlaylistViewHolder(
            ItemPlaylistBinding.inflate(
                LayoutInflater.from(context), parent, false
            ), playlistInteractor
        )

    override fun onBindViewHolder(holder: PlaylistViewHolder, position: Int) {
        holder.bind(currentList[position])
    }
}