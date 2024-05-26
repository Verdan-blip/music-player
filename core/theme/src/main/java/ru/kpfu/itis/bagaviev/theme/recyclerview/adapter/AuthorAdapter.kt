package ru.kpfu.itis.bagaviev.theme.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import ru.kpfu.itis.bagaviev.theme.databinding.ItemAuthorBinding
import ru.kpfu.itis.bagaviev.theme.recyclerview.intercator.AuthorInteractor
import ru.kpfu.itis.bagaviev.theme.recyclerview.model.AuthorRvModel
import ru.kpfu.itis.bagaviev.theme.recyclerview.viewholder.AuthorViewHolder
import ru.kpfu.itis.bagaviev.theme.recyclerview.viewholder.MusicComponentViewHolder

open class AuthorAdapter(
    private val context: Context,
    private val authorInteractor: AuthorInteractor
) : MusicComponentAdapter() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicComponentViewHolder =
        AuthorViewHolder(
            ItemAuthorBinding.inflate(
                LayoutInflater.from(context), parent, false
            ),
            authorInteractor
        )

    override fun onBindViewHolder(holder: MusicComponentViewHolder, position: Int) {
        if (holder is AuthorViewHolder) {
            holder.bind(currentList[position] as AuthorRvModel)
        }
    }
}