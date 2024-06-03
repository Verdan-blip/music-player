package ru.kpfu.itis.bagaviev.feature.upload.domain.usecase

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import ru.kpfu.itis.bagaviev.common.di.modules.IODispatcher
import ru.kpfu.itis.bagaviev.feature.upload.domain.entity.ClipData
import ru.kpfu.itis.bagaviev.feature.upload.domain.entity.NonValidatedTrackUploadForm
import ru.kpfu.itis.bagaviev.feature.upload.domain.entity.TrackUploadForm
import ru.kpfu.itis.bagaviev.feature.upload.domain.exceptions.TrackAudioFileNotDefinedException
import ru.kpfu.itis.bagaviev.feature.upload.domain.exceptions.TrackCoverFileNotDefinedException
import ru.kpfu.itis.bagaviev.feature.upload.domain.exceptions.TrackGenreNotDefinedException
import ru.kpfu.itis.bagaviev.feature.upload.domain.exceptions.TrackTitleNotDefinedException
import ru.kpfu.itis.bagaviev.feature.upload.domain.repository.FeatureUploadTrackRepository
import javax.inject.Inject

class UploadTrackUseCase @Inject constructor(
    private val featureUploadTrackRepository: FeatureUploadTrackRepository,
    @IODispatcher private val coroutineDispatcher: CoroutineDispatcher
) {

    private fun validateTrackUploadForm(trackUploadForm: NonValidatedTrackUploadForm): TrackUploadForm {
        return with (trackUploadForm) {
            if (title == null) throw TrackTitleNotDefinedException()
            if (genre == null) throw TrackGenreNotDefinedException()
            if (audioFile == null) throw TrackAudioFileNotDefinedException()
            if (coverFile == null) throw TrackCoverFileNotDefinedException()
            val clipData = nonValidatedClipData?.run {
                if (clipFile == null || startMs == null || endMs == null)
                    null
                else
                    ClipData(clipFile, startMs, endMs)
            }
            TrackUploadForm(
                title = title,
                genre = genre,
                authors = authors,
                audioFile = audioFile,
                coverFile = coverFile,
                smallCoverFile = smallCoverFile,
                clipData = clipData
            )
        }
    }

    suspend operator fun invoke(nonValidatedTrackUploadForm: NonValidatedTrackUploadForm): Result<Unit> =
        runCatching {
            withContext(coroutineDispatcher) {
                featureUploadTrackRepository.uploadTrack(
                    validateTrackUploadForm(nonValidatedTrackUploadForm)
                )
            }
        }
}