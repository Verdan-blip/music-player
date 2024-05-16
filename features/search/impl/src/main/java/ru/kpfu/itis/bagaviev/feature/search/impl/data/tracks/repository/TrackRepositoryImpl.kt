package ru.kpfu.itis.bagaviev.feature.search.impl.data.tracks.repository

import ru.kpfu.itis.bagaviev.data.music.api.data.network.track.repository.TracksDataRepository
import ru.kpfu.itis.bagaviev.feature.search.api.domain.tracks.entites.Track
import ru.kpfu.itis.bagaviev.feature.search.api.domain.tracks.entites.TrackDetails
import ru.kpfu.itis.bagaviev.feature.search.api.domain.tracks.repository.TrackRepository
import ru.kpfu.itis.bagaviev.feature.search.impl.data.tracks.mappers.toTrack
import ru.kpfu.itis.bagaviev.feature.search.impl.data.tracks.mappers.toTrackDetails
import javax.inject.Inject

class TrackRepositoryImpl @Inject constructor(
    private val tracksDataRepository: TracksDataRepository
) : TrackRepository {

    override suspend fun getCharts(limit: Int, offset: Int): List<Track> =
        tracksDataRepository.getPopularTracks(limit, offset)
            .map { trackDataEntity -> trackDataEntity.toTrack() }

    override suspend fun getById(trackId: Long): TrackDetails? =
        tracksDataRepository.getTrackById(trackId)
            ?.toTrackDetails()
}