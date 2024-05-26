package ru.kpfu.itis.bagaviev.features.feed

import ru.kpfu.itis.bagaviev.data.music.api.data.network.playlist.repository.PlaylistsDataRepository
import ru.kpfu.itis.bagaviev.features.feed.mapper.toPlaylistDetails
import ru.kpfu.itis.bagaviev.feed.api.domain.playlist.entity.PlaylistDetails
import ru.kpfu.itis.bagaviev.feed.api.domain.playlist.repository.FeatureFeedPlaylistRepository
import javax.inject.Inject

class AdapterFeatureFeedPlaylistRepository @Inject constructor(
    private val playlistsDataRepository: PlaylistsDataRepository
) : FeatureFeedPlaylistRepository {

    override suspend fun getById(playlistId: Long): PlaylistDetails? =
        playlistsDataRepository.getPlaylistById(playlistId)
            ?.toPlaylistDetails()
}