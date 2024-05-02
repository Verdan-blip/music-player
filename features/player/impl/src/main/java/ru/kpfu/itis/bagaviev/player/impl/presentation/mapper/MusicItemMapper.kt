package ru.kpfu.itis.bagaviev.player.impl.presentation.mapper

import ru.kpfu.itis.bagaviev.player.api.domain.entities.MusicItem
import ru.kpfu.itis.bagaviev.player.impl.presentation.entities.MusicItemModel
import ru.kpfu.itis.common.util.extensions.toUri

fun MusicItem.toMusicItemModel(): MusicItemModel =
    MusicItemModel(
        id = id,
        title = title,
        authors = authors,
        coverUri = coverUri.toUri()
    )