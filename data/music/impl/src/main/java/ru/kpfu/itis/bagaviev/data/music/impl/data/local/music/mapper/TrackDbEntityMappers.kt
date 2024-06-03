package ru.kpfu.itis.bagaviev.data.music.impl.data.local.music.mapper

import ru.kpfu.itis.bagaviev.data.music.api.data.local.music.entity.DownloadedTrackDataEntity
import ru.kpfu.itis.bagaviev.data.music.impl.data.local.music.entity.DownloadedTrackDbEntity
import ru.kpfu.itis.bagaviev.data.music.impl.data.local.music.entity.TrackWithUsers

fun TrackWithUsers.toDownloadedTrackDataEntity(): DownloadedTrackDataEntity =
    DownloadedTrackDataEntity(
        id = track.id,
        title = track.title,
        smallCoverUri = track.smallCoverUri,
        usersNames = users.map { userDbEntity -> userDbEntity.login },
        audioUri = track.audioUri
    )

fun DownloadedTrackDataEntity.toDownloadedTrackDbEntity(): DownloadedTrackDbEntity =
    DownloadedTrackDbEntity(
        id = id,
        title = title,
        smallCoverUri = smallCoverUri,
        audioUri = audioUri
    )