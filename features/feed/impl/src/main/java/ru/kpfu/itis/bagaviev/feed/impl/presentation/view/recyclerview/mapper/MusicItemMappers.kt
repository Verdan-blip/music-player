package ru.kpfu.itis.bagaviev.feed.impl.presentation.view.recyclerview.mapper

import ru.kpfu.itis.bagaviev.feed.impl.presentation.entity.track.TrackModel
import ru.kpfu.itis.bagaviev.player.api.domain.entities.MusicItem

fun MusicItem.toTrackModel(): TrackModel =
    TrackModel(
        id = id,
        title = title,
        smallCoverUri = coverUri.toString(),
        authorNames = authors
    )