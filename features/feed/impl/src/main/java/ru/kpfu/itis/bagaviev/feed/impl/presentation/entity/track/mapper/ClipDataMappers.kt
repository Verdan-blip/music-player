package ru.kpfu.itis.bagaviev.feed.impl.presentation.entity.track.mapper

import ru.kpfu.itis.bagaviev.feed.api.domain.track.entity.TrackClipData
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entity.track.TrackClipDataModel


fun TrackClipData.toTrackClipDataModel(): TrackClipDataModel =
    TrackClipDataModel(
        clipUri = clipUri,
        clipStart = clipStart,
        clipEnd = clipEnd
    )