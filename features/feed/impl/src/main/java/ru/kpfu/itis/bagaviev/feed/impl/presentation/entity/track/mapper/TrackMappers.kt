package ru.kpfu.itis.bagaviev.feed.impl.presentation.entity.track.mapper

import ru.kpfu.itis.bagaviev.feed.api.domain.track.entity.Track
import ru.kpfu.itis.bagaviev.feed.api.domain.track.entity.TrackDetails
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entity.track.TrackDetailsModel
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entity.track.TrackModel
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entity.user.mapper.toUser
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entity.user.mapper.toUserModel
import ru.kpfu.itis.bagaviev.common.util.extensions.toURI
import ru.kpfu.itis.bagaviev.common.util.extensions.toUri

fun Track.toTrackModel(): TrackModel =
    TrackModel(
        id = id,
        title = title,
        users = users.map { user -> user.toUserModel() },
        smallCoverUri = smallCoverUri.toUri()
    )

fun TrackModel.toTrack(): Track =
    Track(
        id = id,
        title = title,
        users = users.map { user -> user.toUser() },
        smallCoverUri = smallCoverUri.toURI()
    )

fun TrackDetails.toTrackDetailsModel(): TrackDetailsModel =
    TrackDetailsModel(
        id = id,
        title = title,
        smallCoverUri = smallCoverUri.toUri(),
        coverUri = coverUri.toUri(),
        audioFileUri = audioFileUri.toUri(),
        releaseDate = releaseDate,
        playsCount = playsCount,
        genre = genre,
        users = users.map { user -> user.toUserModel() },
        videoFileUri = videoFileUri?.toUri()
    )

fun TrackDetailsModel.toTrackDetails(): TrackDetails =
    TrackDetails(
        id = id,
        title = title,
        smallCoverUri = smallCoverUri.toURI(),
        coverUri = coverUri.toURI(),
        audioFileUri = audioFileUri.toURI(),
        videoFileUri = videoFileUri?.toURI(),
        releaseDate = releaseDate,
        playsCount = playsCount,
        genre = genre,
        users = users.map { user -> user.toUser() }
    )