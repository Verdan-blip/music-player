package ru.kpfu.itis.bagaviev.features.feed.mapper

import ru.kpfu.itis.bagaviev.data.music.api.data.network.track.entity.ClipDataEntity
import ru.kpfu.itis.bagaviev.data.music.api.data.network.track.entity.TrackDataEntity
import ru.kpfu.itis.bagaviev.data.music.api.data.network.track.entity.TrackDetailsDataEntity
import ru.kpfu.itis.bagaviev.feed.api.domain.track.entity.Track
import ru.kpfu.itis.bagaviev.feed.api.domain.track.entity.TrackClipData
import ru.kpfu.itis.bagaviev.feed.api.domain.track.entity.TrackDetails

fun ClipDataEntity.toClipData(): TrackClipData =
    TrackClipData(
        clipUri = clipFileUri,
        clipStart = clipStart,
        clipEnd = clipEnd
    )

fun TrackDataEntity.toTrack(): Track = Track(
    id = id,
    title = title,
    authorsNames = usersNames,
    smallCoverUri = smallCoverUri
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
    playsCount = playsCount,
    trackClipData = clipDataEntity?.toClipData()
)