package ru.kpfu.itis.bagaviev.feed.api.domain.track.usecase

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import ru.kpfu.itis.bagaviev.feed.api.domain.track.entity.Track
import ru.kpfu.itis.bagaviev.feed.api.domain.track.repository.TrackRepository

class GetPopularTracksUseCase(
    private val trackRepository: TrackRepository,
    private val coroutineDispatcher: CoroutineDispatcher
) {

    suspend operator fun invoke(limit: Int = 10, offset: Int = 0): Result<List<Track>> =
        runCatching {
            withContext(coroutineDispatcher) {
                trackRepository.getCharts(limit, offset)
            }
        }
}
