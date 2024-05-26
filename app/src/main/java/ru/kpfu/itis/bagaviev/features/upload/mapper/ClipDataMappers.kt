package ru.kpfu.itis.bagaviev.features.upload.mapper

import ru.kpfu.itis.bagaviev.data.music.api.data.network.upload.entity.ClipFormDataEntity
import ru.kpfu.itis.bagaviev.feature.upload.domain.entity.ClipData

fun ClipData.toClipDataEntity(): ClipFormDataEntity =
    ClipFormDataEntity(
        clipFile = clipFile,
        clipStartMs = startMs,
        clipEndMs = endMs
    )
