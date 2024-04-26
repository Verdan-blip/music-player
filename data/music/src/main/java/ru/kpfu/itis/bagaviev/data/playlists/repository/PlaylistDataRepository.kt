package ru.kpfu.itis.bagaviev.data.playlists.repository

import ru.kpfu.itis.bagaviev.data.playlists.entities.responses.PlaylistDetailsResponseEntity
import ru.kpfu.itis.bagaviev.data.playlists.entities.responses.PlaylistResponseEntity
import ru.kpfu.itis.bagaviev.data.playlists.service.PlaylistApiService

class PlaylistDataRepository(
    private val playlistApiService: PlaylistApiService
) {

    fun getById(playlistId: Long): PlaylistDetailsResponseEntity =
        playlistApiService.getById(playlistId)

    fun getAllByKeywords(
        keywords: List<String>,
        limit: Int = 10,
        offset: Int = 0
    ): List<PlaylistResponseEntity> =
        playlistApiService.getAllByKeywords(keywords.joinToString(separator = "+"))
}