package ru.kpfu.itis.bagaviev.data.music.api.data.network.playlist.repository

import ru.kpfu.itis.bagaviev.data.music.api.data.network.playlist.entity.PlaylistDetailsDataEntity

interface PlaylistsDataRepository {

    suspend fun getPlaylistById(playlistId: Long): PlaylistDetailsDataEntity?
}