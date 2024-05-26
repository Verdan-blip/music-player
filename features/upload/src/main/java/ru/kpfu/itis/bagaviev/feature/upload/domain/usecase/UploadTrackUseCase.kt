package ru.kpfu.itis.bagaviev.feature.upload.domain.usecase

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import ru.kpfu.itis.bagaviev.common.di.modules.IODispatcher
import ru.kpfu.itis.bagaviev.feature.upload.domain.entity.TrackUploadForm
import ru.kpfu.itis.bagaviev.feature.upload.domain.repository.FeatureUploadTrackRepository
import javax.inject.Inject

class UploadTrackUseCase @Inject constructor(
    private val featureUploadTrackRepository: FeatureUploadTrackRepository,
    @IODispatcher private val coroutineDispatcher: CoroutineDispatcher
) {

    suspend operator fun invoke(trackUploadForm: TrackUploadForm): Result<Unit> =
        runCatching {
            withContext(coroutineDispatcher) {
                featureUploadTrackRepository.uploadTrack(trackUploadForm)
            }
        }
}