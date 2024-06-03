package ru.kpfu.itis.bagaviev.feed.api.domain.playlist.usecases

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import ru.kpfu.itis.bagaviev.common.di.modules.IODispatcher
import ru.kpfu.itis.bagaviev.feed.api.domain.playlist.entity.PlaylistDetails
import ru.kpfu.itis.bagaviev.feed.api.domain.playlist.repository.FeatureFeedPlaylistRepository

class GetPlaylistDetailsByIdUseCase(
    private val featureFeedPlaylistRepository: FeatureFeedPlaylistRepository,
    @IODispatcher private val coroutineDispatcher: CoroutineDispatcher
) {

    suspend operator fun invoke(playlistId: Long): Result<PlaylistDetails?> =
        runCatching {
            withContext(coroutineDispatcher) {
                featureFeedPlaylistRepository.getById(playlistId)
            }
        }
}