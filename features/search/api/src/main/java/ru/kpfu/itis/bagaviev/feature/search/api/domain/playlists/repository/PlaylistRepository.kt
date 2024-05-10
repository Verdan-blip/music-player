package ru.kpfu.itis.bagaviev.feature.search.api.domain.playlists.repository

import ru.kpfu.itis.bagaviev.feature.search.api.domain.playlists.entites.PlaylistDetails
import ru.kpfu.itis.bagaviev.feature.search.api.domain.playlists.entites.Playlist

interface PlaylistRepository {

    suspend fun getById(playlistId: Long): PlaylistDetails?

    suspend fun getPopularPlaylists(limit: Int = 5, offset: Int = 0): List<Playlist>
}