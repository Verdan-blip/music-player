package ru.kpfu.itis.bagaviev.feed.api.domain.playlists.usecases

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import ru.kpfu.itis.bagaviev.feed.api.domain.playlists.entites.Playlist
import ru.kpfu.itis.bagaviev.feed.api.domain.playlists.repository.PlaylistRepository
import ru.kpfu.itis.common.di.modules.IODispatcher

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