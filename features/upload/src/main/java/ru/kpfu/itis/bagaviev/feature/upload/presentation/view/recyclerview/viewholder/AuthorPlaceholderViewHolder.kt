package ru.kpfu.itis.bagaviev.feature.upload.presentation.view.recyclerview.viewholder

import ru.kpfu.itis.bagaviev.theme.databinding.ItemAuthorAddBinding
import ru.kpfu.itis.bagaviev.feature.upload.presentation.view.recyclerview.interactor.AuthorPlaceholderInteractor
import ru.kpfu.itis.bagaviev.theme.recyclerview.viewholder.MusicComponentViewHolder

class AuthorPlaceholderViewHolder(
    viewBinding: ItemAuthorAddBinding,
    authorPlaceholderInteractor: AuthorPlaceholderInteractor
) : MusicComponentViewHolder(viewBinding.root) {

    init {
        viewBinding.root.setOnClickListener {
            authorPlaceholderInteractor.onClick()
        }
    }

}