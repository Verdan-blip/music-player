package ru.kpfu.itis.bagaviev.presentation.util

import ru.kpfu.itis.bagaviev.common.base.music.BaseMusicViewModel
import ru.kpfu.itis.bagaviev.player.api.domain.entities.ClipData

fun BaseMusicViewModel.ClipData.toClipData(): ClipData =
    ClipData(
        clipUri = clipUri,
        clipStart = clipStart,
        clipEnd = clipEnd
    )

fun ClipData.toClipData(): BaseMusicViewModel.ClipData =
    BaseMusicViewModel.ClipData(
        clipUri = clipUri,
        clipStart = clipStart,
        clipEnd = clipEnd
    )