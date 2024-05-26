package ru.kpfu.itis.bagaviev.feature.search.api.domain.track.entity

import ru.kpfu.itis.bagaviev.feature.search.api.domain.author.entity.Author

class Track(
    val id: Long,
    val title: String,
    val authors: List<Author>,
    val smallCoverUri: String
)