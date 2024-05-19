package ru.kpfu.itis.bagaviev.feed.api.domain.playlist.repository

import ru.kpfu.itis.bagaviev.feed.api.domain.playlist.entity.PlaylistDetails
import ru.kpfu.itis.bagaviev.feed.api.domain.playlist.entity.Playlist

interface PlaylistRepository {

    suspend fun getById(playlistId: Long): PlaylistDetails?
}