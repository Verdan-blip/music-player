package ru.kpfu.itis.bagaviev.feature.upload.presentation.entity

data class UserModel(
    val id: Long,
    val login: String,
    val avatarUri: String
)