package ru.kpfu.itis.bagaviev.feed.api.domain.track.entity

import ru.kpfu.itis.bagaviev.feed.api.domain.author.entity.Author

class Track(
    val id: Long,
    val title: String,
    val authors: List<Author>,
    val smallCoverUri: String
)