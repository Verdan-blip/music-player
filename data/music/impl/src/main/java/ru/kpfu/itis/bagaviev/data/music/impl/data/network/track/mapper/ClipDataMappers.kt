package ru.kpfu.itis.bagaviev.data.music.impl.data.network.track.mapper

import ru.kpfu.itis.bagaviev.data.music.api.data.network.track.entity.ClipDataEntity
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.track.pojo.responses.ClipData

fun ClipData.toClipDataEntity(): ClipDataEntity =
    ClipDataEntity(
        clipFileUri = clipFileUri,
        clipStart = clipStart,
        clipEnd = clipEnd
    )