package ru.kpfu.itis.bagaviev.impl.presentation.mapper

import ru.kpfu.itis.bagaviev.api.domain.entities.MusicItem
import ru.kpfu.itis.bagaviev.impl.presentation.entities.MusicItemModel
import ru.kpfu.itis.common.util.extensions.toUri

fun MusicItem.toMusicItemModel(): MusicItemModel =
    MusicItemModel(
        id = id,
        title = title,
        authors = authors,
        coverUri = coverUri.toUri()
    )