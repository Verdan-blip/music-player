package ru.kpfu.itis.bagaviev.feature.upload.presentation.view.recyclerview.viewholder

import androidx.recyclerview.widget.RecyclerView
import coil.load
import ru.kpfu.itis.bagaviev.feature.upload.R
import ru.kpfu.itis.bagaviev.feature.upload.databinding.ItemFoundAuthorBinding
import ru.kpfu.itis.bagaviev.feature.upload.presentation.entity.UserModel
import ru.kpfu.itis.bagaviev.feature.upload.presentation.view.recyclerview.interactor.FoundAuthorInteractor

class FoundAuthorViewHolder(
    private val viewBinding: ItemFoundAuthorBinding,
    private val interactor: FoundAuthorInteractor
) : RecyclerView.ViewHolder(viewBinding.root) {

    private var currentUser: UserModel? = null

    init {
        viewBinding.root.setOnClickListener {
            currentUser?.apply {
                interactor.onClick(id)
            }
        }
    }

    fun bind(userModel: UserModel) {
        currentUser = userModel
        viewBinding.apply {
            root.context.resources.apply {
                tvAuthorId.text = getString(R.string.search_users_item_id_format, userModel.id)
                tvAuthorLogin.text = getString(R.string.search_users_item_login_format, userModel.login)
            }
            ivAuthorAvatar.load(userModel.avatarUri)
        }
    }
}