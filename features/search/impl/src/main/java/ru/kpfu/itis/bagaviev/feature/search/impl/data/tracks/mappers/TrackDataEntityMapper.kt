package ru.kpfu.itis.bagaviev.feature.search.impl.data.tracks.mappers

import ru.kpfu.itis.bagaviev.data.music.api.data.network.track.entity.TrackDataEntity
import ru.kpfu.itis.bagaviev.data.music.api.data.network.track.entity.TrackDetailsDataEntity
import ru.kpfu.itis.bagaviev.feature.search.api.domain.track.entity.Track
import ru.kpfu.itis.bagaviev.feature.search.api.domain.track.entity.TrackDetails
import ru.kpfu.itis.bagaviev.feature.search.impl.data.users.mappers.toUser

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