package ru.kpfu.itis.bagaviev.feature.upload.presentation.mapper

import ru.kpfu.itis.bagaviev.feature.upload.domain.entity.NonValidatedClipData
import ru.kpfu.itis.bagaviev.feature.upload.presentation.entity.ClipDataModel

fun ClipDataModel.toNonValidatedClipData(): NonValidatedClipData = NonValidatedClipData(
    clipFile = clipFile,
    startMs = startMs,
    endMs = endMs
)