package ru.kpfu.itis.bagaviev.feature.search.impl.data.tracks.repository

import ru.kpfu.itis.bagaviev.data.music.api.data.network.track.repository.TracksDataRepository
import ru.kpfu.itis.bagaviev.feature.search.api.domain.track.entity.Track
import ru.kpfu.itis.bagaviev.feature.search.api.domain.track.entity.TrackDetails
import ru.kpfu.itis.bagaviev.feature.search.api.domain.track.repository.TrackRepository
import ru.kpfu.itis.bagaviev.feature.search.impl.data.tracks.mappers.toTrack
import ru.kpfu.itis.bagaviev.feature.search.impl.data.tracks.mappers.toTrackDetails
import javax.inject.Inject

class TrackRepositoryImpl @Inject constructor(
    private val tracksDataRepository: TracksDataRepository
) : TrackRepository {

    override suspend fun getById(trackId: Long): TrackDetails? =
        tracksDataRepository.getTrackById(trackId)
            ?.toTrackDetails()
}