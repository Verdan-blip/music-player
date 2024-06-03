package ru.kpfu.itis.bagaviev.feature.upload.presentation.view.recyclerview.diffutil

import androidx.recyclerview.widget.DiffUtil
import ru.kpfu.itis.bagaviev.feature.upload.presentation.entity.UserFeedModel

class FoundAuthorItemCallback : DiffUtil.ItemCallback<UserFeedModel>() {

    override fun areItemsTheSame(oldItem: UserFeedModel, newItem: UserFeedModel): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: UserFeedModel, newItem: UserFeedModel): Boolean =
        oldItem == newItem
}