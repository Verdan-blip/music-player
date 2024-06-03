package ru.kpfu.itis.bagaviev.feed.api.domain.track.usecase

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import ru.kpfu.itis.bagaviev.feed.api.domain.track.entity.TrackDetails
import ru.kpfu.itis.bagaviev.feed.api.domain.track.repository.FeatureFeedTrackRepository

class GetTrackDetailsByIdUseCase(
    private val featureFeedTrackRepository: FeatureFeedTrackRepository,
    private val coroutineDispatcher: CoroutineDispatcher
) {

    suspend operator fun invoke(trackId: Long): Result<TrackDetails?> =
        runCatching {
            withContext(coroutineDispatcher) {
                featureFeedTrackRepository.getById(trackId)
            }
        }
}