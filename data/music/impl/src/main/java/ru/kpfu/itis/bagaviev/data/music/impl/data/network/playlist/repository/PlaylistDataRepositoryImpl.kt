package ru.kpfu.itis.bagaviev.data.music.impl.data.network.playlist.repository

import ru.kpfu.itis.bagaviev.data.music.api.data.network.playlist.entities.PlaylistDataEntity
import ru.kpfu.itis.bagaviev.data.music.api.data.network.playlist.entities.PlaylistDetailsDataEntity
import ru.kpfu.itis.bagaviev.data.music.api.data.network.playlist.repository.PlaylistsDataRepository
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.playlist.mapper.toPlaylistDataEntity
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.playlist.mapper.toPlaylistDetailsDataEntity
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.playlist.service.PlaylistApiService
import javax.inject.Inject

class PlaylistDataRepositoryImpl @Inject constructor(
    private val playlistApiService: PlaylistApiService
) : PlaylistsDataRepository {

    override suspend fun getPlaylistById(playlistId: Long): PlaylistDetailsDataEntity? =
        playlistApiService.getById(playlistId)
            ?.toPlaylistDetailsDataEntity()

    override suspend fun getPopularPlaylists(limit: Int, offset: Int): List<PlaylistDataEntity> =
        playlistApiService.getPopularPlaylists(limit, offset)
            .map { playlistResponse -> playlistResponse.toPlaylistDataEntity() }
}