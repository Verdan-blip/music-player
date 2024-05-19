package ru.kpfu.itis.bagaviev.feature.search.api.domain.track.usecase

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import ru.kpfu.itis.bagaviev.feature.search.api.domain.track.entity.TrackDetails
import ru.kpfu.itis.bagaviev.feature.search.api.domain.track.repository.TrackRepository

class GetTrackDetailsByIdUseCase(
    private val trackRepository: TrackRepository,
    private val coroutineDispatcher: CoroutineDispatcher
) {

    suspend operator fun invoke(trackId: Long): TrackDetails? =
        withContext(coroutineDispatcher) {
            trackRepository.getById(trackId)
        }
}