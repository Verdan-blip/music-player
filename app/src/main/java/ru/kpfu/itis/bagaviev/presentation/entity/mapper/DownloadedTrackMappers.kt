package ru.kpfu.itis.bagaviev.presentation.entity.mapper

import ru.kpfu.itis.bagaviev.data.music.api.data.local.music.entity.DownloadedTrackDataEntity
import ru.kpfu.itis.bagaviev.presentation.entity.DownloadedTrackModel

fun DownloadedTrackModel.toDownloadedTrackDataEntity(): DownloadedTrackDataEntity =
    DownloadedTrackDataEntity(
        id = id,
        title = title,
        usersNames = users,
        smallCoverUri = smallCoverUri,
        audioUri = audiUri
    )