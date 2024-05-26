package ru.kpfu.itis.bagaviev.feed.impl.presentation.view.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import ru.kpfu.itis.bagaviev.feed.impl.presentation.view.recyclerview.holder.PlaylistViewHolder
import ru.kpfu.itis.bagaviev.theme.databinding.ItemPlaylistBinding
import ru.kpfu.itis.bagaviev.theme.recyclerview.intercator.PlaylistInteractor
import ru.kpfu.itis.bagaviev.theme.recyclerview.adapter.MusicComponentAdapter
import ru.kpfu.itis.bagaviev.theme.recyclerview.model.PlaylistRvModel
import ru.kpfu.itis.bagaviev.theme.recyclerview.viewholder.MusicComponentViewHolder

class PlaylistAdapter(
    private val context: Context,
    private val interactor: PlaylistInteractor
) : MusicComponentAdapter() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicComponentViewHolder =
        PlaylistViewHolder(
            ItemPlaylistBinding.inflate(
                LayoutInflater.from(context), parent, false
            ), interactor
        )

    override fun onBindViewHolder(holder: MusicComponentViewHolder, position: Int) {
        if (holder is PlaylistViewHolder) {
            holder.bind(currentList[position] as PlaylistRvModel)
        }
    }
}