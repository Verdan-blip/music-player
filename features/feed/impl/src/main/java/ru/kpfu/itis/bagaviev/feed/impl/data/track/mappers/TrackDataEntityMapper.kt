package ru.kpfu.itis.bagaviev.feed.impl.data.track.mappers

import ru.kpfu.itis.bagaviev.data.music.api.data.network.track.entities.TrackDataEntity
import ru.kpfu.itis.bagaviev.data.music.api.data.network.track.entities.TrackDetailsDataEntity
import ru.kpfu.itis.bagaviev.feed.api.domain.track.entity.Track
import ru.kpfu.itis.bagaviev.feed.api.domain.track.entity.TrackDetails
import ru.kpfu.itis.bagaviev.feed.impl.data.user.mapper.toUser

fun TrackDataEntity.toTrack(): Track = Track(
    id = id,
    title = title,
    users = users.map { user -> user.toUser() },
    smallCoverUri = smallCoverUri
)

fun TrackDetailsDataEntity.toTrackDetails(): TrackDetails = TrackDetails(
    id = id,
    title = title,
    coverUri = coverUri,
    users = users.map { user -> user.toUser() },
    genre = genre,
    lyrics = lyrics,
    smallCoverUri = smallCoverUri,
    audioFileUri = audioFileUri,
    videoFileUri = videoFileUri,
    releaseDate = releaseDate,
    playsCount = playsCount
)