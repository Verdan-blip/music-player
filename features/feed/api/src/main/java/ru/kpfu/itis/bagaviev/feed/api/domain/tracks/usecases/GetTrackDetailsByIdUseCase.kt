package ru.kpfu.itis.bagaviev.feed.api.domain.tracks.usecases

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import ru.kpfu.itis.bagaviev.feed.api.domain.tracks.entites.TrackDetails
import ru.kpfu.itis.bagaviev.feed.api.domain.tracks.repository.TrackRepository

class GetTrackDetailsByIdUseCase(
    private val trackRepository: TrackRepository,
    private val coroutineDispatcher: CoroutineDispatcher
) {

    suspend operator fun invoke(trackId: Long): TrackDetails? =
        withContext(coroutineDispatcher) {
            trackRepository.getById(trackId)
        }
}