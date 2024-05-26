package ru.kpfu.itis.bagaviev.feature.upload.domain.entity

import java.net.URI

data class User(
    val id: Long,
    val login: String,
    val avatarUri: URI?
)