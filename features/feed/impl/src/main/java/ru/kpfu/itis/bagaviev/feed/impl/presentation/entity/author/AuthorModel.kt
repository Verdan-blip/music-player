package ru.kpfu.itis.bagaviev.feed.impl.presentation.entity.author

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AuthorModel(
    val id: Long,
    val login: String
) : Parcelable