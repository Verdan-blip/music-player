package ru.kpfu.itis.bagaviev.feature.search.impl.presentation.view.util

import ru.kpfu.itis.bagaviev.common.util.extensions.toURI
import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.entities.track.TrackDetailsModel
import ru.kpfu.itis.bagaviev.player.api.domain.entities.MusicItem

fun TrackDetailsModel.toMusicItem(): MusicItem =
    MusicItem(
        id = id,
        title = title,
        authors = users.map { user -> user.login },
        genre = genre,
        audioFileUri = audioFileUri.toURI(),
        videoFileUri = null,
        coverUri = coverUri.toURI()
    )