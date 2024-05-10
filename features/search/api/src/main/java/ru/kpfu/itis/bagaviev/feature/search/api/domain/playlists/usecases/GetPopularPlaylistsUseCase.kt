package ru.kpfu.itis.bagaviev.feature.search.api.domain.playlists.usecases

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import ru.kpfu.itis.bagaviev.common.di.modules.IODispatcher
import ru.kpfu.itis.bagaviev.feature.search.api.domain.playlists.entites.Playlist
import ru.kpfu.itis.bagaviev.feature.search.api.domain.playlists.repository.PlaylistRepository

class GetPopularPlaylistsUseCase(
    private val playlistRepository: PlaylistRepository,
    @IODispatcher private val coroutineDispatcher: CoroutineDispatcher
) {

    suspend operator fun invoke(): Result<List<Playlist>> =
        runCatching {
            withContext(coroutineDispatcher) {
                playlistRepository.getPopularPlaylists()
            }
        }
}