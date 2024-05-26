package ru.kpfu.itis.bagaviev.data.music.api.data.network.upload.repository

import ru.kpfu.itis.bagaviev.data.music.api.data.network.upload.entity.TrackUploadFormDataEntity

interface UploadTrackDataRepository {

    suspend fun uploadTrack(trackUploadForm: TrackUploadFormDataEntity)
}