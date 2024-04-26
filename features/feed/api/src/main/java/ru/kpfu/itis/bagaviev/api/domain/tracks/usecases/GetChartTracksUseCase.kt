package ru.kpfu.itis.bagaviev.api.domain.tracks.usecases

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import ru.kpfu.itis.bagaviev.api.domain.tracks.entites.responses.TrackResponse
import ru.kpfu.itis.bagaviev.api.domain.tracks.repository.TrackRepository

class GetChartTracksUseCase(
    private val trackRepository: TrackRepository,
    private val coroutineDispatcher: CoroutineDispatcher
) {

    suspend operator fun invoke(limit: Int = 10, offset: Int = 0): Result<List<TrackResponse>> =
        runCatching {
            withContext(coroutineDispatcher) {
                trackRepository.getCharts(limit, offset)
            }
        }
}
