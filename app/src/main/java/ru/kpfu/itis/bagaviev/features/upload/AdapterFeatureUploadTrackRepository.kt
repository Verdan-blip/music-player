package ru.kpfu.itis.bagaviev.features.upload

import ru.kpfu.itis.bagaviev.data.music.api.data.network.upload.repository.UploadTrackDataRepository
import ru.kpfu.itis.bagaviev.feature.upload.domain.entity.TrackUploadForm
import ru.kpfu.itis.bagaviev.feature.upload.domain.repository.FeatureUploadTrackRepository
import ru.kpfu.itis.bagaviev.features.upload.mapper.toTrackUploadFormDataEntity
import javax.inject.Inject

class AdapterFeatureUploadTrackRepository @Inject constructor(
    private val uploadTrackDataRepository: UploadTrackDataRepository
) : FeatureUploadTrackRepository {

    override suspend fun uploadTrack(trackForm: TrackUploadForm) {
        uploadTrackDataRepository.uploadTrack(
            trackForm.toTrackUploadFormDataEntity()
        )
    }
}