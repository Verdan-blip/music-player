package ru.kpfu.itis.bagaviev.feature.search.impl.data.playlist.repository

import ru.kpfu.itis.bagaviev.data.music.api.data.network.playlist.repository.PlaylistsDataRepository
import ru.kpfu.itis.bagaviev.feature.search.api.domain.playlists.entity.PlaylistDetails
import ru.kpfu.itis.bagaviev.feature.search.api.domain.playlists.repository.PlaylistRepository
import ru.kpfu.itis.bagaviev.feature.search.impl.data.playlist.mappers.toPlaylistDetails
import javax.inject.Inject

class PlaylistRepositoryImpl @Inject constructor(
    private val playlistsDataRepository: PlaylistsDataRepository
) : PlaylistRepository {

    override suspend fun getById(playlistId: Long): PlaylistDetails? =
        playlistsDataRepository.getPlaylistById(playlistId)
            ?.toPlaylistDetails()
}