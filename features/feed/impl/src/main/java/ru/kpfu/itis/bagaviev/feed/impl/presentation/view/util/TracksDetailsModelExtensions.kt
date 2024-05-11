package ru.kpfu.itis.bagaviev.feed.impl.presentation.view.util

import ru.kpfu.itis.bagaviev.common.util.extensions.toURI
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entities.tracks.TrackDetailsModel
import ru.kpfu.itis.bagaviev.player.api.domain.entities.MusicItem

fun TrackDetailsModel.toMusicItem(): MusicItem =
    MusicItem(
        id = id,
        title = title,
        authors = users.map { user -> user.login },
        genre = genre,
        audioFileUri = audioFileUri.toURI(),
        videoFileUri = videoFileUri?.toURI(),
        coverUri = coverUri.toURI()
    )