package ru.kpfu.itis.bagaviev.feed.impl.presentation.entities.tracks.mappers

import androidx.core.net.toUri
import ru.kpfu.itis.bagaviev.feed.api.domain.tracks.entites.Track
import ru.kpfu.itis.bagaviev.feed.api.domain.tracks.entites.TrackDetails
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entities.tracks.TrackDetailsModel
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entities.tracks.TrackModel
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entities.users.mappers.toUser
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entities.users.mappers.toUserModel
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