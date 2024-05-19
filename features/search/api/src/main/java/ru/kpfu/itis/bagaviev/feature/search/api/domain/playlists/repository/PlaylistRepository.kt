package ru.kpfu.itis.bagaviev.feature.search.api.domain.playlists.repository

import ru.kpfu.itis.bagaviev.feature.search.api.domain.playlists.entity.PlaylistDetails

interface PlaylistRepository {

    suspend fun getById(playlistId: Long): PlaylistDetails?
}