package ru.kpfu.itis.bagaviev.feature.search.api.domain.track.usecase

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import ru.kpfu.itis.bagaviev.feature.search.api.domain.track.entity.TrackDetails
import ru.kpfu.itis.bagaviev.feature.search.api.domain.track.repository.FeatureSearchTrackRepository

class GetTrackDetailsByIdUseCase(
    private val featureSearchTrackRepository: FeatureSearchTrackRepository,
    private val coroutineDispatcher: CoroutineDispatcher
) {

    suspend operator fun invoke(trackId: Long): Result<TrackDetails?> =
        runCatching {
            withContext(coroutineDispatcher) {
                featureSearchTrackRepository.getById(trackId)
            }
        }
}