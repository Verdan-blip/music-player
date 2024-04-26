package ru.kpfu.itis.bagaviev.api.domain.playlists.repository

import ru.kpfu.itis.bagaviev.api.domain.playlists.entites.responses.PlaylistDetailsResponse
import ru.kpfu.itis.bagaviev.api.domain.playlists.entites.responses.PlaylistResponse

interface PlaylistRepository {

    fun getById(playlistId: Long): PlaylistDetailsResponse

    fun getAllByKeywords(
        keywords: List<String>,
        limit: Int = 10,
        offset: Int = 0
    ): List<PlaylistResponse>
}