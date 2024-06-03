package ru.kpfu.itis.bagaviev.feature.profile.presentation.entity.track.mapper

import ru.kpfu.itis.bagaviev.feature.profile.domain.entity.track.DownloadedTrack
import ru.kpfu.itis.bagaviev.feature.profile.domain.entity.track.MyTrack
import ru.kpfu.itis.bagaviev.feature.profile.presentation.entity.track.DownloadedTrackModel
import ru.kpfu.itis.bagaviev.feature.profile.presentation.entity.track.MyTrackModel

fun MyTrack.toMyTrackModel(): MyTrackModel =
    MyTrackModel(
        id = id,
        title = title,
        authors = authors,
        smallCoverUri = smallCoverUri
    )

fun DownloadedTrack.toDownloadedTrackModel(): DownloadedTrackModel =
    DownloadedTrackModel(
        id = id,
        title = title,
        authors = authors,
        smallCoverUri = smallCoverUri,
        audioUri = audioUri
    )