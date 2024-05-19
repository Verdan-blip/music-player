package ru.kpfu.itis.bagaviev.data.music.impl.data.network.playlist.repository

import ru.kpfu.itis.bagaviev.data.music.api.data.network.playlist.entity.PlaylistDetailsDataEntity
import ru.kpfu.itis.bagaviev.data.music.api.data.network.playlist.repository.PlaylistsDataRepository
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.playlist.mapper.toPlaylistDetailsDataEntity
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.playlist.service.PlaylistApiService
import javax.inject.Inject

class PlaylistDataRepositoryImpl @Inject constructor(
    private val playlistApiService: PlaylistApiService
) : PlaylistsDataRepository {

    override suspend fun getPlaylistById(playlistId: Long): PlaylistDetailsDataEntity? =
        playlistApiService.getById(playlistId)
            ?.toPlaylistDetailsDataEntity()
}