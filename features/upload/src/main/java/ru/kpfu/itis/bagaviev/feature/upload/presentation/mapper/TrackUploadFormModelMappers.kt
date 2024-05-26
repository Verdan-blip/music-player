package ru.kpfu.itis.bagaviev.feature.upload.presentation.mapper

import ru.kpfu.itis.bagaviev.feature.upload.domain.entity.TrackUploadForm
import ru.kpfu.itis.bagaviev.feature.upload.presentation.entity.TrackUploadFormModel

fun TrackUploadFormModel.toTrackUpload(): TrackUploadForm = TrackUploadForm(
    title = title,
    users = users.map { userModel -> userModel.toUser() },
    audioFile = audioFile,
    coverFile = coverFile,
    smallCoverFile = smallCoverFile,
    clipData = clipData?.toClipData()
)