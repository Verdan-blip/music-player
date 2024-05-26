package ru.kpfu.itis.bagaviev.feature.search.impl.presentation.entities.track

import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.entities.author.AuthorModel

data class TrackModel(
    val id: Long,
    val title: String,
    val smallCoverUri: String,
    val authors: List<AuthorModel>
)