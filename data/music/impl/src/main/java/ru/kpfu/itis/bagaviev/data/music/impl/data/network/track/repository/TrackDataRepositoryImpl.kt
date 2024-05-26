package ru.kpfu.itis.bagaviev.data.music.impl.data.network.track.repository

import ru.kpfu.itis.bagaviev.data.music.api.data.network.track.entity.TrackDetailsDataEntity
import ru.kpfu.itis.bagaviev.data.music.api.data.network.track.repository.TrackDataRepository
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.track.mapper.toTrackDetailsDataEntity
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.track.service.TrackApiService
import javax.inject.Inject

class TrackDataRepositoryImpl @Inject constructor(
    private val trackApiService: TrackApiService
) : TrackDataRepository {

    override suspend fun getTrackById(trackId: Long): TrackDetailsDataEntity? =
        trackApiService.getTrackById(trackId)
            ?.toTrackDetailsDataEntity()
}