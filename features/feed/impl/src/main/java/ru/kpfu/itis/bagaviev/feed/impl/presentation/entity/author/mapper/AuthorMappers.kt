package ru.kpfu.itis.bagaviev.feed.impl.presentation.entity.author.mapper

import ru.kpfu.itis.bagaviev.feed.api.domain.author.entity.Author
import ru.kpfu.itis.bagaviev.feed.api.domain.author.entity.AuthorFeed
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entity.author.AuthorFeedModel
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entity.author.AuthorModel


fun Author.toAuthorModel(): AuthorModel =
    AuthorModel(
        id = id,
        login = login
    )

fun AuthorFeed.toAuthorFeedModel(): AuthorFeedModel =
    AuthorFeedModel(
        id = id,
        login = login,
        avatarUri = avatarUri
    )

