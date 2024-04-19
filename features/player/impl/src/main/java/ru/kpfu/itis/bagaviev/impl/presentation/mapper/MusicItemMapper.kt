package ru.kpfu.itis.bagaviev.impl.presentation.mapper

import android.net.Uri
import ru.kpfu.itis.bagaviev.api.domain.entities.MusicItem
import ru.kpfu.itis.bagaviev.impl.presentation.entities.MusicItemModel

fun MusicItem.toMusicItemModel(): MusicItemModel =
    MusicItemModel(
        id = id,
        title = title,
        authors = authors,
        posterUri = Uri.parse(posterUri.toString()),
        duration = duration
    )