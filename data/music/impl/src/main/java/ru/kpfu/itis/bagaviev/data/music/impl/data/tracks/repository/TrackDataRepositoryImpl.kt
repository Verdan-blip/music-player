package ru.kpfu.itis.bagaviev.data.music.impl.data.tracks.repository

import ru.kpfu.itis.bagaviev.data.music.api.data.tracks.entities.TrackDataEntity
import ru.kpfu.itis.bagaviev.data.music.api.data.tracks.entities.TrackDetailsDataEntity
import ru.kpfu.itis.bagaviev.data.music.api.data.tracks.repository.TracksDataRepository
import ru.kpfu.itis.bagaviev.data.music.impl.data.tracks.mapper.toTrackDataEntity
import ru.kpfu.itis.bagaviev.data.music.impl.data.tracks.mapper.toTrackDetailsDataEntity
import ru.kpfu.itis.bagaviev.data.music.impl.data.tracks.service.TrackApiService
import javax.inject.Inject

class TrackDataRepositoryImpl @Inject constructor(
    private val trackApiService: TrackApiService
) : TracksDataRepository {

    override suspend fun getTrackById(trackId: Long): TrackDetailsDataEntity? =
        trackApiService.getTrackById(trackId)
            ?.toTrackDetailsDataEntity()

    override suspend fun getPopularTracks(limit: Int, offset: Int): List<TrackDataEntity> =
        trackApiService.getPopularTracks(limit, offset)
            .map { trackResponse -> trackResponse.toTrackDataEntity() }
}