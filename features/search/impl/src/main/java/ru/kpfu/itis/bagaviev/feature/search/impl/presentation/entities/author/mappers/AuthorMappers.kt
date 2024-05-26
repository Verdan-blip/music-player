package ru.kpfu.itis.bagaviev.feature.search.impl.presentation.entities.author.mappers

import ru.kpfu.itis.bagaviev.feature.search.api.domain.author.entity.Author
import ru.kpfu.itis.bagaviev.feature.search.api.domain.author.entity.AuthorFeed
import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.entities.author.AuthorFeedModel
import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.entities.author.AuthorModel

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