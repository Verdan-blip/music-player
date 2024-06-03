package ru.kpfu.itis.bagaviev.feature.upload.presentation.view.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import ru.kpfu.itis.bagaviev.feature.upload.presentation.view.recyclerview.entity.AuthorPlaceholderRvModel
import ru.kpfu.itis.bagaviev.feature.upload.presentation.view.recyclerview.interactor.AuthorPlaceholderInteractor
import ru.kpfu.itis.bagaviev.feature.upload.presentation.view.recyclerview.viewholder.AuthorPlaceholderViewHolder
import ru.kpfu.itis.bagaviev.theme.databinding.ItemAuthorAddBinding
import ru.kpfu.itis.bagaviev.theme.databinding.ItemAuthorBinding
import ru.kpfu.itis.bagaviev.theme.recyclerview.adapter.AuthorAdapter
import ru.kpfu.itis.bagaviev.theme.recyclerview.exceptions.UnknownViewTypeException
import ru.kpfu.itis.bagaviev.theme.recyclerview.intercator.AuthorInteractor
import ru.kpfu.itis.bagaviev.theme.recyclerview.model.AuthorRvModel
import ru.kpfu.itis.bagaviev.theme.recyclerview.model.base.MusicComponentRvModel
import ru.kpfu.itis.bagaviev.theme.recyclerview.viewholder.AuthorViewHolder
import ru.kpfu.itis.bagaviev.theme.recyclerview.viewholder.MusicComponentViewHolder

class AddAuthorAdapter(
    private val context: Context,
    private val authorInteractor: AuthorInteractor,
    private val authorPlaceholderInteractor: AuthorPlaceholderInteractor
) : AuthorAdapter(context, authorInteractor) {

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> VIEW_TYPE_AUTHOR_PLACEHOLDER
            else -> VIEW_TYPE_AUTHOR
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicComponentViewHolder {
        val inflater = LayoutInflater.from(context)
        return when (viewType) {
            VIEW_TYPE_AUTHOR -> AuthorViewHolder(
                ItemAuthorBinding.inflate(inflater, parent, false),
                authorInteractor
            )
            VIEW_TYPE_AUTHOR_PLACEHOLDER -> AuthorPlaceholderViewHolder(
                ItemAuthorAddBinding.inflate(inflater, parent, false),
                authorPlaceholderInteractor
            )
            else -> throw UnknownViewTypeException(viewType)
        }
    }

    override fun onBindViewHolder(holder: MusicComponentViewHolder, position: Int) {
        when (holder) {
            is AuthorViewHolder -> {
                holder.bind(currentList[position] as AuthorRvModel)
            }
        }
    }

    fun submitData(users: List<AuthorRvModel>) {
        val newList = mutableListOf<MusicComponentRvModel>()
        newList.add(AuthorPlaceholderRvModel())
        newList.addAll(users)
        super.submitList(newList)
    }


    companion object {

        const val VIEW_TYPE_AUTHOR_PLACEHOLDER = 0
        const val VIEW_TYPE_AUTHOR = 1
    }
}