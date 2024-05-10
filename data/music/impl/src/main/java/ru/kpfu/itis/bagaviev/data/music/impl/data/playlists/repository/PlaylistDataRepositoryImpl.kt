package ru.kpfu.itis.bagaviev.data.music.impl.data.playlists.repository

import ru.kpfu.itis.bagaviev.data.music.api.data.playlists.entities.PlaylistDataEntity
import ru.kpfu.itis.bagaviev.data.music.api.data.playlists.entities.PlaylistDetailsDataEntity
import ru.kpfu.itis.bagaviev.data.music.api.data.playlists.repository.PlaylistsDataRepository
import ru.kpfu.itis.bagaviev.data.music.impl.data.playlists.mapper.toPlaylistDataEntity
import ru.kpfu.itis.bagaviev.data.music.impl.data.playlists.mapper.toPlaylistDetailsDataEntity
import ru.kpfu.itis.bagaviev.data.music.impl.data.playlists.service.PlaylistApiService
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