package ru.kpfu.itis.bagaviev.feature.search.impl.presentation.view.reclycerview.mappers

import ru.kpfu.itis.bagaviev.feature.search.api.domain.track.entity.Track
import ru.kpfu.itis.bagaviev.theme.recyclerview.model.TrackRvModel

fun Track.toTrackRvModel(): TrackRvModel =
    TrackRvModel(
        id = id,
        title = title,
        authorNames = authors.map { userModel -> userModel.login },
        smallCoverUri = smallCoverUri.toString()
    )