package ru.kpfu.itis.bagaviev.data.music.api.data.network.user.entity

import android.net.Uri

class UserDataEntity(
    val id: Long,
    val login: String,
    val avatarUri: Uri?
)