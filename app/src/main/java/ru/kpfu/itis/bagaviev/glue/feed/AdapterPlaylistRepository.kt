package ru.kpfu.itis.bagaviev.glue.feed

import ru.kpfu.itis.bagaviev.feed.api.domain.playlists.entites.PlaylistDetails
import ru.kpfu.itis.bagaviev.feed.api.domain.playlists.entites.Playlist
import ru.kpfu.itis.bagaviev.feed.api.domain.playlists.repository.PlaylistRepository
import ru.kpfu.itis.bagaviev.music.data.playlists.repository.PlaylistDataRepository
import ru.kpfu.itis.bagaviev.glue.feed.mappers.playlists.toPlaylistDetailsResponse
import ru.kpfu.itis.bagaviev.glue.feed.mappers.playlists.toPlaylistResponse
import javax.inject.Inject

class AdapterPlaylistRepository @Inject constructor(
    private val playlistDataRepository: PlaylistDataRepository
) : PlaylistRepository {

    override suspend fun getById(playlistId: Long): PlaylistDetails? =
        playlistDataRepository.getById(playlistId)?.toPlaylistDetailsResponse()

    override suspend fun getPopularPlaylists(limit: Int, offset: Int): List<Playlist> =
        playlistDataRepository.getPopularPlaylists(limit, offset)
            .map { playlistResponse -> playlistResponse.toPlaylistResponse() }

    override suspend fun getAllByKeywords(
        keywords: List<String>,
        limit: Int,
        offset: Int
    ): List<Playlist> =
        playlistDataRepository.getAllByKeywords(keywords, limit, offset).map { playlistResponse ->
            playlistResponse.toPlaylistResponse()
        }
}