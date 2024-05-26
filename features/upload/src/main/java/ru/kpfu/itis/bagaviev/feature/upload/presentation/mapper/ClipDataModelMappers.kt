package ru.kpfu.itis.bagaviev.feature.upload.presentation.mapper

import ru.kpfu.itis.bagaviev.feature.upload.domain.entity.ClipData
import ru.kpfu.itis.bagaviev.feature.upload.presentation.entity.ClipDataModel

fun ClipDataModel.toClipData(): ClipData = ClipData(
    clipFile = clipFile,
    startMs = startMs,
    endMs = endMs
)