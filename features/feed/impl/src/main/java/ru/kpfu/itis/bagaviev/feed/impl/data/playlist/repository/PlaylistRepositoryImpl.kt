package ru.kpfu.itis.bagaviev.feed.impl.data.playlist.repository

import ru.kpfu.itis.bagaviev.data.music.api.data.network.playlist.repository.PlaylistsDataRepository
import ru.kpfu.itis.bagaviev.feed.api.domain.playlist.entity.Playlist
import ru.kpfu.itis.bagaviev.feed.api.domain.playlist.entity.PlaylistDetails
import ru.kpfu.itis.bagaviev.feed.api.domain.playlist.repository.PlaylistRepository
import ru.kpfu.itis.bagaviev.feed.impl.data.playlist.mapper.toPlaylist
import ru.kpfu.itis.bagaviev.feed.impl.data.playlist.mapper.toPlaylistDetails
import javax.inject.Inject

class PlaylistRepositoryImpl @Inject constructor(
    private val playlistsDataRepository: PlaylistsDataRepository
) : PlaylistRepository {

    override suspend fun getById(playlistId: Long): PlaylistDetails? =
        playlistsDataRepository.getPlaylistById(playlistId)
            ?.toPlaylistDetails()
}