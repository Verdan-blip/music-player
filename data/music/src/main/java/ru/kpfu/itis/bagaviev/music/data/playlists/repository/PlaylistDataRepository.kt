package ru.kpfu.itis.bagaviev.music.data.playlists.repository

import ru.kpfu.itis.bagaviev.music.data.playlists.entities.responses.PlaylistDetailsResponseEntity
import ru.kpfu.itis.bagaviev.music.data.playlists.entities.responses.PlaylistResponseEntity
import ru.kpfu.itis.bagaviev.music.data.playlists.service.PlaylistApiService
import javax.inject.Inject

class PlaylistDataRepository @Inject constructor(
    private val playlistApiService: PlaylistApiService
) {

    suspend fun getById(playlistId: Long): PlaylistDetailsResponseEntity? =
        playlistApiService.getById(playlistId)

    suspend fun getPopularPlaylists(
        limit: Int = 5, offset: Int = 0
    ): List<PlaylistResponseEntity> =
        playlistApiService.getPopularPlaylists(limit, offset)

    suspend fun getAllByKeywords(
        keywords: List<String>,
        limit: Int = 10,
        offset: Int = 0
    ): List<PlaylistResponseEntity> =
        playlistApiService.getAllByKeywords(keywords.joinToString(separator = "+"))
}