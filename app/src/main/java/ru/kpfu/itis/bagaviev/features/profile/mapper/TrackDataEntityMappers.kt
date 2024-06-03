package ru.kpfu.itis.bagaviev.features.profile.mapper

import ru.kpfu.itis.bagaviev.data.music.api.data.local.music.entity.DownloadedTrackDataEntity
import ru.kpfu.itis.bagaviev.data.music.api.data.network.track.entity.TrackDataEntity
import ru.kpfu.itis.bagaviev.feature.profile.domain.entity.track.DownloadedTrack
import ru.kpfu.itis.bagaviev.feature.profile.domain.entity.track.MyTrack

fun TrackDataEntity.toMyTrack(): MyTrack = MyTrack(
    id = id,
    title = title,
    smallCoverUri = smallCoverUri,
    authors = usersNames
)

fun DownloadedTrackDataEntity.toDownloadedTrack(): DownloadedTrack =
    DownloadedTrack(
        id = id,
        title = title,
        authors = usersNames,
        smallCoverUri = smallCoverUri,
        audioUri = audioUri
    )