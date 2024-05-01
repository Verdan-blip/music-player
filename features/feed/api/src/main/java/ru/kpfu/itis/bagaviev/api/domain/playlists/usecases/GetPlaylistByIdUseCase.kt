package ru.kpfu.itis.bagaviev.api.domain.playlists.usecases

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import ru.kpfu.itis.bagaviev.api.domain.playlists.entites.PlaylistDetails
import ru.kpfu.itis.bagaviev.api.domain.playlists.repository.PlaylistRepository
import ru.kpfu.itis.common.di.modules.IODispatcher

class GetPlaylistByIdUseCase(
    private val playlistRepository: PlaylistRepository,
    @IODispatcher private val coroutineDispatcher: CoroutineDispatcher
) {

    suspend operator fun invoke(playlistId: Long): PlaylistDetails? =
        withContext(coroutineDispatcher) {
            playlistRepository.getById(playlistId)
        }
}