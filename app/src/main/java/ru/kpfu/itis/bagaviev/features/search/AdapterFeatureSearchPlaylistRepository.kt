package ru.kpfu.itis.bagaviev.features.search

import ru.kpfu.itis.bagaviev.data.music.api.data.network.playlist.repository.PlaylistsDataRepository
import ru.kpfu.itis.bagaviev.feature.search.api.domain.playlists.entity.PlaylistDetails
import ru.kpfu.itis.bagaviev.feature.search.api.domain.playlists.repository.FeatureSearchPlaylistRepository
import ru.kpfu.itis.bagaviev.features.search.mapper.toPlaylistDetails
import javax.inject.Inject

class AdapterFeatureSearchPlaylistRepository @Inject constructor(
    private val playlistsDataRepository: PlaylistsDataRepository
) : FeatureSearchPlaylistRepository {

    override suspend fun getById(playlistId: Long): PlaylistDetails? =
        playlistsDataRepository.getPlaylistById(playlistId)
            ?.toPlaylistDetails()
}