package ru.kpfu.itis.bagaviev.feature.search.impl.presentation.entities.track

import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.entities.author.AuthorModel
import java.util.Date

class TrackDetailsModel(
    val id: Long,
    val title: String,
    val genre: String,
    val users: List<AuthorModel>,
    val smallCoverUri: String,
    val coverUri: String,
    val audioFileUri: String,
    val releaseDate: Date,
    val playsCount: Int
)