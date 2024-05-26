package ru.kpfu.itis.bagaviev.theme.recyclerview.viewholder

import coil.load
import ru.kpfu.itis.bagaviev.theme.databinding.ItemAuthorBinding
import ru.kpfu.itis.bagaviev.theme.recyclerview.intercator.AuthorInteractor
import ru.kpfu.itis.bagaviev.theme.recyclerview.model.AuthorRvModel

class AuthorViewHolder(
    private val viewBinding: ItemAuthorBinding,
    private val interactor: AuthorInteractor
) : MusicComponentViewHolder(viewBinding.root) {

    private val currentAuthor: AuthorRvModel? = null

    init {
        viewBinding.root.apply {
            setOnLongClickListener {
                currentAuthor?.apply {
                    interactor.onLongClick(id)
                }
                true
            }
        }
    }

    fun bind(authorModel: AuthorRvModel) {
        viewBinding.ivAuthor.load(authorModel.avatarUri)
    }
}