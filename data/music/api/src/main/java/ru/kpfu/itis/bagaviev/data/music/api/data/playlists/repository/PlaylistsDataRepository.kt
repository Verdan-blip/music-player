package ru.kpfu.itis.bagaviev.data.music.api.data.playlists.repository

import ru.kpfu.itis.bagaviev.data.music.api.data.playlists.entities.PlaylistDataEntity
import ru.kpfu.itis.bagaviev.data.music.api.data.playlists.entities.PlaylistDetailsDataEntity

interface PlaylistsDataRepository {

    suspend fun getPlaylistById(playlistId: Long): PlaylistDetailsDataEntity?

    suspend fun getPopularPlaylists(limit: Int, offset: Int): List<PlaylistDataEntity>
}