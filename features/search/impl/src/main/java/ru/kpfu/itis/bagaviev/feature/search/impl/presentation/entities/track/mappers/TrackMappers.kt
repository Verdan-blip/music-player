package ru.kpfu.itis.bagaviev.feature.search.impl.presentation.entities.track.mappers

import ru.kpfu.itis.bagaviev.feature.search.api.domain.track.entity.Track
import ru.kpfu.itis.bagaviev.feature.search.api.domain.track.entity.TrackDetails
import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.entities.author.mappers.toAuthorModel
import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.entities.track.TrackDetailsModel
import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.entities.track.TrackModel

fun Track.toTrackModel(): TrackModel =
    TrackModel(
        id = id,
        title = title,
        smallCoverUri = smallCoverUri,
        authorNames = authorNames
    )

fun TrackDetails.toTrackDetailsModel(): TrackDetailsModel =
    TrackDetailsModel(
        id = id,
        title = title,
        smallCoverUri = smallCoverUri,
        coverUri = coverUri,
        audioFileUri = audioFileUri,
        releaseDate = releaseDate,
        playsCount = playsCount,
        genre = genre,
        authors = authors.map { user -> user.toAuthorModel() },
    )