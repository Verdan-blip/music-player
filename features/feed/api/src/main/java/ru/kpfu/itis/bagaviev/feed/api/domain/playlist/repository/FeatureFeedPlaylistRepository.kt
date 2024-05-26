package ru.kpfu.itis.bagaviev.feed.api.domain.playlist.repository

import ru.kpfu.itis.bagaviev.feed.api.domain.playlist.entity.PlaylistDetails

interface FeatureFeedPlaylistRepository {

    suspend fun getById(playlistId: Long): PlaylistDetails?
}