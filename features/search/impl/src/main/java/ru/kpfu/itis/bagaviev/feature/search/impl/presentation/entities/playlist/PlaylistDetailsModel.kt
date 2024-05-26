package ru.kpfu.itis.bagaviev.feature.search.impl.presentation.entities.playlist

import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.entities.author.AuthorModel
import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.entities.track.TrackModel
import java.util.Date

class PlaylistDetailsModel(
    val id: Long,
    val title: String,
    val user: AuthorModel,
    val coverUri: String,
    val tracks: List<TrackModel>,
    val createdTime: Date,
    val playsCount: Int
)