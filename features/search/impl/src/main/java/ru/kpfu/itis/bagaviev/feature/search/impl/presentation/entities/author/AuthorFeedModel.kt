package ru.kpfu.itis.bagaviev.feature.search.impl.presentation.entities.author

data class AuthorFeedModel(
    val id: Long,
    val login: String,
    val avatarUri: String
)