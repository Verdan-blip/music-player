package ru.kpfu.itis.bagaviev.feature.profile.presentation.view.mapper

import ru.kpfu.itis.bagaviev.feature.profile.presentation.entity.track.DownloadedTrackModel
import ru.kpfu.itis.bagaviev.feature.profile.presentation.entity.track.MyTrackModel
import ru.kpfu.itis.bagaviev.theme.recyclerview.model.TrackRvModel

fun MyTrackModel.toTrackRvModel(): TrackRvModel =
    TrackRvModel(
        id = id,
        title = title,
        authorNames = authors,
        smallCoverUri = smallCoverUri
    )

fun DownloadedTrackModel.toTrackRvModel(): TrackRvModel =
    TrackRvModel(
        id = id,
        title = title,
        authorNames = authors,
        smallCoverUri = smallCoverUri
    )