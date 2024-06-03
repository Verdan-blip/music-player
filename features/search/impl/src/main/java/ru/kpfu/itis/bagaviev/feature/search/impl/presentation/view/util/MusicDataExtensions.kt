package ru.kpfu.itis.bagaviev.feature.search.impl.presentation.view.util

import ru.kpfu.itis.bagaviev.common.base.music.BaseMusicViewModel
import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.entities.track.TrackDetailsModel
import ru.kpfu.itis.bagaviev.theme.recyclerview.model.TrackRvModel

fun TrackDetailsModel.toMusicData(): BaseMusicViewModel.MusicData =
    BaseMusicViewModel.MusicData(
        id = id,
        title = title,
        audioUri = audioFileUri,
        coverUri = coverUri,
        authors = authors.map { authorModel -> authorModel.login }
    )

fun TrackDetailsModel.toTrackRvModel(): TrackRvModel =
    TrackRvModel(
        id = id,
        title = title,
        smallCoverUri = smallCoverUri,
        authorNames = authors.map { authorModel -> authorModel.login }
    )