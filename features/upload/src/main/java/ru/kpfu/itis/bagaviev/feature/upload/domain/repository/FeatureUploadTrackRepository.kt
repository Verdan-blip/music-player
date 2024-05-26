package ru.kpfu.itis.bagaviev.feature.upload.domain.repository

import ru.kpfu.itis.bagaviev.feature.upload.domain.entity.TrackUploadForm

interface FeatureUploadTrackRepository {

    suspend fun uploadTrack(trackForm: TrackUploadForm)
}