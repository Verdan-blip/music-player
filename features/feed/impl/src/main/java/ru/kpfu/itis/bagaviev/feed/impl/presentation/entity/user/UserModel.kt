package ru.kpfu.itis.bagaviev.feed.impl.presentation.entity.user

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
class UserModel(
    val id: Long,
    val login: String
) : Parcelable