package ru.kpfu.itis.bagaviev.data.music.impl.data.network.track.mapper

import ru.kpfu.itis.bagaviev.common.util.extensions.toURI
import ru.kpfu.itis.bagaviev.data.music.api.data.network.track.entity.ClipDataEntity
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.track.pojo.responses.ClipData

fun ClipData.toClipDataEntity(): ClipDataEntity =
    ClipDataEntity(
        clipFileUri = clipFileUri.toURI(),
        clipStart = clipStart,
        clipEnd = clipEnd
    )