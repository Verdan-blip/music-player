package ru.kpfu.itis.bagaviev.data.music.api.data.network.track.repository

import ru.kpfu.itis.bagaviev.data.music.api.data.network.track.entities.TrackDataEntity
import ru.kpfu.itis.bagaviev.data.music.api.data.network.track.entities.TrackDetailsDataEntity

interface TracksDataRepository {

    suspend fun getTrackById(trackId: Long): TrackDetailsDataEntity?

    suspend fun getPopularTracks(limit: Int, offset: Int): List<TrackDataEntity>
}