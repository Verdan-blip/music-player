package ru.kpfu.itis.bagaviev.features.upload.mapper

import ru.kpfu.itis.bagaviev.data.music.api.data.network.upload.entity.TrackUploadFormDataEntity
import ru.kpfu.itis.bagaviev.feature.upload.domain.entity.TrackUploadForm

fun TrackUploadForm.toTrackUploadFormDataEntity(): TrackUploadFormDataEntity =
    TrackUploadFormDataEntity(
        title = title,
        users = users.map { user -> user.toUserDataEntity() },
        audioFile = audioFile,
        coverFile = coverFile,
        smallCoverFile = smallCoverFile,
        clipData = clipData?.toClipDataEntity()
    )