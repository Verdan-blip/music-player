package ru.kpfu.itis.bagaviev.data.playlists.repository

import ru.kpfu.itis.bagaviev.data.playlists.entities.responses.PlaylistDetailsResponse
import ru.kpfu.itis.bagaviev.data.playlists.entities.responses.PlaylistResponse
import ru.kpfu.itis.bagaviev.data.playlists.service.PlaylistApiService

class PlaylistDataRepository(
    private val playlistApiService: PlaylistApiService
) {

    fun getById(playlistId: Long): PlaylistDetailsResponse =
        playlistApiService.getById(playlistId)

    fun getAllByKeywords(
        keywords: List<String>,
        limit: Int = 10,
        offset: Int = 0
    ): List<PlaylistResponse> =
        playlistApiService.getAllByKeywords(keywords.joinToString(separator = "+"))
}