package ru.kpfu.itis.bagaviev.feature.search.api.domain.playlists.usecase

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import ru.kpfu.itis.bagaviev.common.di.modules.IODispatcher
import ru.kpfu.itis.bagaviev.feature.search.api.domain.playlists.entity.PlaylistDetails
import ru.kpfu.itis.bagaviev.feature.search.api.domain.playlists.repository.PlaylistRepository

class GetPlaylistDetailsByIdUseCase(
    private val playlistRepository: PlaylistRepository,
    @IODispatcher private val coroutineDispatcher: CoroutineDispatcher
) {

    suspend operator fun invoke(playlistId: Long): PlaylistDetails? =
        withContext(coroutineDispatcher) {
            playlistRepository.getById(playlistId)
        }
}