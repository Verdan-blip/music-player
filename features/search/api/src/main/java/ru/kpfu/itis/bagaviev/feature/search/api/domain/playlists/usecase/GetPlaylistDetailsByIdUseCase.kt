package ru.kpfu.itis.bagaviev.feature.search.api.domain.playlists.usecase

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import ru.kpfu.itis.bagaviev.common.di.modules.IODispatcher
import ru.kpfu.itis.bagaviev.feature.search.api.domain.playlists.entity.PlaylistDetails
import ru.kpfu.itis.bagaviev.feature.search.api.domain.playlists.repository.FeatureSearchPlaylistRepository

class GetPlaylistDetailsByIdUseCase(
    private val featureSearchPlaylistRepository: FeatureSearchPlaylistRepository,
    @IODispatcher private val coroutineDispatcher: CoroutineDispatcher
) {

    suspend operator fun invoke(playlistId: Long): Result<PlaylistDetails?> =
        runCatching {
            withContext(coroutineDispatcher) {
                featureSearchPlaylistRepository.getById(playlistId)
            }
        }
}