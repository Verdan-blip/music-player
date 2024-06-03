package ru.kpfu.itis.bagaviev.feature.profile.domain.usecase

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import ru.kpfu.itis.bagaviev.common.di.modules.IODispatcher
import ru.kpfu.itis.bagaviev.feature.profile.domain.entity.track.DownloadedTrack
import ru.kpfu.itis.bagaviev.feature.profile.domain.repository.FeatureProfileDownloadedTrackRepository
import javax.inject.Inject

class GetAllDownloadedTracksUseCase @Inject constructor(
    private val downloadedTrackRepository: FeatureProfileDownloadedTrackRepository,
    @IODispatcher private val coroutineDispatcher: CoroutineDispatcher
) {

    suspend operator fun invoke(): Result<List<DownloadedTrack>> =
        runCatching {
            withContext(coroutineDispatcher) {
                downloadedTrackRepository.getAll()
            }
        }
}