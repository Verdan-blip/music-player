package ru.kpfu.itis.bagaviev.feature.search.api.domain.tracks.usecases

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import ru.kpfu.itis.bagaviev.feature.search.api.domain.tracks.entites.Track
import ru.kpfu.itis.bagaviev.feature.search.api.domain.tracks.repository.TrackRepository

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
