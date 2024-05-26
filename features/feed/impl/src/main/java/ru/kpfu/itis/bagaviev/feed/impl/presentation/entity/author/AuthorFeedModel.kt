package ru.kpfu.itis.bagaviev.feed.impl.presentation.entity.author

data class AuthorFeedModel(
    val id: Long,
    val login: String,
    val avatarUri: String
)