package ru.kpfu.itis.bagaviev.features.search.mapper

import ru.kpfu.itis.bagaviev.data.music.api.data.network.track.entity.TrackDataEntity
import ru.kpfu.itis.bagaviev.data.music.api.data.network.track.entity.TrackDetailsDataEntity
import ru.kpfu.itis.bagaviev.feature.search.api.domain.track.entity.Track
import ru.kpfu.itis.bagaviev.feature.search.api.domain.track.entity.TrackDetails

fun TrackDataEntity.toTrack(): Track = Track(
    id = id,
    title = title,
    authors = users.map { user -> user.toUser() },
    smallCoverUri = smallCoverUri.toString()
)

fun TrackDetailsDataEntity.toTrackDetails(): TrackDetails = TrackDetails(
    id = id,
    title = title,
    coverUri = coverUri.toString(),
    authors = users.map { user -> user.toUser() },
    genre = genre,
    lyrics = lyrics,
    smallCoverUri = smallCoverUri.toString(),
    audioFileUri = audioFileUri.toString(),
    releaseDate = releaseDate,
    playsCount = playsCount
)