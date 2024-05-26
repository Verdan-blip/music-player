package ru.kpfu.itis.bagaviev.feed.impl.presentation.entity.track.mapper

import ru.kpfu.itis.bagaviev.common.util.extensions.toUri
import ru.kpfu.itis.bagaviev.feed.api.domain.track.entity.Track
import ru.kpfu.itis.bagaviev.feed.api.domain.track.entity.TrackDetails
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entity.author.mapper.toAuthorModel
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entity.track.TrackDetailsModel
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entity.track.TrackModel

fun Track.toTrackModel(): TrackModel =
    TrackModel(
        id=  id,
        title = title,
        smallCoverUri = smallCoverUri,
        authorNames = authors.map { user -> user.login }
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
        users = authors.map { user -> user.toAuthorModel() },
    )