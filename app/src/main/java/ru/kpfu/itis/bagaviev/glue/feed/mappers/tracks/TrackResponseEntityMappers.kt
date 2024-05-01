package ru.kpfu.itis.bagaviev.glue.feed.mappers.tracks

import ru.kpfu.itis.bagaviev.api.domain.tracks.entites.TrackDetails
import ru.kpfu.itis.bagaviev.api.domain.tracks.entites.Track
import ru.kpfu.itis.bagaviev.data.tracks.entities.responses.TrackDetailsResponseEntity
import ru.kpfu.itis.bagaviev.data.tracks.entities.responses.TrackResponseEntity
import ru.kpfu.itis.bagaviev.glue.feed.mappers.users.toUserResponse
import ru.kpfu.itis.bagaviev.glue.feed.mappers.users.toUserResponseEntity
import ru.kpfu.itis.common.util.extensions.toURI
import java.sql.Date
import java.sql.Timestamp

fun Track.toTrackResponseEntity(): TrackResponseEntity =
    TrackResponseEntity(
        id = id,
        title = title,
        users = users.map { user -> user.toUserResponseEntity() },
        smallCoverUri = smallCoverUri
    )

fun TrackResponseEntity.toTrack(): Track =
    Track(
        id = id,
        title = title,
        users = users.map { user -> user.toUserResponse() },
        smallCoverUri = smallCoverUri
    )

fun TrackDetails.toTrackDetailsResponseEntity(): TrackDetailsResponseEntity =
    TrackDetailsResponseEntity(
        id = id,
        title = title,
        genre = genre,
        users = users.map { user -> user.toUserResponseEntity() },
        smallCoverUri = smallCoverUri.toString(),
        coverUri = coverUri.toString(),
        audioFileUri = coverUri.toString(),
        videoFileUri = videoFileUri.toString(),
        releaseDate = releaseDate.toString(),
        playsCount = playsCount
    )

fun TrackDetailsResponseEntity.toTrackDetails(): TrackDetails =
    TrackDetails(
        id = id,
        title = title,
        genre = genre,
        users = users.map { user -> user.toUserResponse() },
        smallCoverUri = smallCoverUri.toURI(),
        coverUri = coverUri.toURI(),
        audioFileUri = coverUri.toURI(),
        videoFileUri = videoFileUri?.toURI(),
        releaseDate = Date.valueOf(releaseDate),
        playsCount = playsCount
    )