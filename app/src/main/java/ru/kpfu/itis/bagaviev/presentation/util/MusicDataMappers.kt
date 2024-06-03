package ru.kpfu.itis.bagaviev.presentation.util

import ru.kpfu.itis.bagaviev.common.base.music.BaseMusicViewModel
import ru.kpfu.itis.bagaviev.player.api.domain.entities.MusicItem

fun MusicItem.toMusicData(): BaseMusicViewModel.MusicData =
        BaseMusicViewModel.MusicData(
            id = id,
            title = title,
            audioUri = audioFileUri,
            coverUri = coverUri,
            authors = authors,
            clipData = clipData?.toClipData()
        )

fun BaseMusicViewModel.MusicData.toMusicItem(): MusicItem =
        MusicItem(
            id = id,
            title = title,
            audioFileUri = audioUri,
            coverUri = coverUri,
            authors = authors,
            clipData = clipData?.toClipData()
        )