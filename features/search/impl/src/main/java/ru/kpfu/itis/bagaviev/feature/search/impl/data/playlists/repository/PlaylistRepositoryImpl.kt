package ru.kpfu.itis.bagaviev.feature.search.impl.data.playlists.repository

import ru.kpfu.itis.bagaviev.data.music.api.data.playlists.repository.PlaylistsDataRepository
import ru.kpfu.itis.bagaviev.feature.search.api.domain.playlists.entites.Playlist
import ru.kpfu.itis.bagaviev.feature.search.api.domain.playlists.entites.PlaylistDetails
import ru.kpfu.itis.bagaviev.feature.search.api.domain.playlists.repository.PlaylistRepository
import ru.kpfu.itis.bagaviev.feature.search.impl.data.playlists.mappers.toPlaylist
import ru.kpfu.itis.bagaviev.feature.search.impl.data.playlists.mappers.toPlaylistDetails
import javax.inject.Inject

class PlaylistRepositoryImpl @Inject constructor(
    private val playlistsDataRepository: PlaylistsDataRepository
) : PlaylistRepository {

    override suspend fun getById(playlistId: Long): PlaylistDetails? =
        playlistsDataRepository.getPlaylistById(playlistId)
            ?.toPlaylistDetails()

    override suspend fun getPopularPlaylists(limit: Int, offset: Int): List<Playlist> =
        playlistsDataRepository.getPopularPlaylists(limit, offset)
            .map { playlistDataEntity -> playlistDataEntity.toPlaylist() }
}