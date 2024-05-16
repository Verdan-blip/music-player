package ru.kpfu.itis.bagaviev.data.music.api.data.network.playlist.repository

import ru.kpfu.itis.bagaviev.data.music.api.data.network.playlist.entities.PlaylistDataEntity
import ru.kpfu.itis.bagaviev.data.music.api.data.network.playlist.entities.PlaylistDetailsDataEntity

interface PlaylistsDataRepository {

    suspend fun getPlaylistById(playlistId: Long): PlaylistDetailsDataEntity?

    suspend fun getPopularPlaylists(limit: Int, offset: Int): List<PlaylistDataEntity>
}