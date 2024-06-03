package ru.kpfu.itis.bagaviev.feature.upload.presentation.mapper

import ru.kpfu.itis.bagaviev.feature.upload.domain.entity.NonValidatedTrackUploadForm
import ru.kpfu.itis.bagaviev.feature.upload.presentation.entity.TrackUploadFormModel

fun TrackUploadFormModel.toNonValidatedTrackUploadForm(): NonValidatedTrackUploadForm =
    NonValidatedTrackUploadForm(
        title = title,
        genre = genre,
        authors = authors.map { userModel -> userModel.toUser() },
        audioFile = audioFile,
        coverFile = coverFile,
        smallCoverFile = smallCoverFile,
        nonValidatedClipData = clipData?.toNonValidatedClipData()
    )