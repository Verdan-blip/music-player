package ru.kpfu.itis.bagaviev.feature.upload.presentation.view.recyclerview.diffutil

import androidx.recyclerview.widget.DiffUtil
import ru.kpfu.itis.bagaviev.feature.upload.presentation.entity.UserModel

class FoundAuthorItemCallback : DiffUtil.ItemCallback<UserModel>() {

    override fun areItemsTheSame(oldItem: UserModel, newItem: UserModel): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: UserModel, newItem: UserModel): Boolean =
        oldItem == newItem
}