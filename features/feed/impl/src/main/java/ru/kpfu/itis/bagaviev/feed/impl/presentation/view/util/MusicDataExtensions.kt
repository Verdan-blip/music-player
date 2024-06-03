package ru.kpfu.itis.bagaviev.feed.impl.presentation.view.util

import ru.kpfu.itis.bagaviev.common.base.music.BaseMusicViewModel
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entity.track.TrackClipDataModel
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entity.track.TrackDetailsModel
import ru.kpfu.itis.bagaviev.theme.recyclerview.model.TrackRvModel

fun TrackClipDataModel.toClipData(): BaseMusicViewModel.ClipData =
    BaseMusicViewModel.ClipData(
        clipUri = clipUri,
        clipStart = clipStart,
        clipEnd = clipEnd
    )

fun TrackDetailsModel.toMusicData(): BaseMusicViewModel.MusicData =
    BaseMusicViewModel.MusicData(
        id = id,
        title = title,
        audioUri = audioFileUri,
        coverUri = coverUri,
        authors = authors.map { authorModel -> authorModel.login },
        clipData = clipData?.toClipData()
    )

fun TrackDetailsModel.toTrackRvModel(): TrackRvModel =
    TrackRvModel(
        id = id,
        title = title,
        smallCoverUri = smallCoverUri,
        authorNames = authors.map { authorModel -> authorModel.login }
    )