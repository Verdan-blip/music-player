package ru.kpfu.itis.bagaviev.feed.impl.presentation.view.util

import ru.kpfu.itis.bagaviev.common.util.extensions.toURI
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entity.track.TrackDetailsModel
import ru.kpfu.itis.bagaviev.player.api.domain.entities.MusicItem
import ru.kpfu.itis.bagaviev.theme.recyclerview.model.TrackRvModel

fun TrackDetailsModel.toMusicItem(): MusicItem =
    MusicItem(
        id = id,
        title = title,
        authors = users.map { user -> user.login },
        genre = genre,
        audioFileUri = audioFileUri.toURI(),
        coverUri = coverUri.toURI()
    )

fun MusicItem.toTrackRvModel(): TrackRvModel =
    TrackRvModel(
        id = id,
        title = title,
        authorNames = authors,
        smallCoverUri = coverUri.toString(),
    )