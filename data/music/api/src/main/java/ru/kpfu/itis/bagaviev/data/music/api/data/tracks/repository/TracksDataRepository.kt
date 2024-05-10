package ru.kpfu.itis.bagaviev.data.music.api.data.tracks.repository

import ru.kpfu.itis.bagaviev.data.music.api.data.tracks.entities.TrackDataEntity
import ru.kpfu.itis.bagaviev.data.music.api.data.tracks.entities.TrackDetailsDataEntity

interface TracksDataRepository {

    suspend fun getTrackById(trackId: Long): TrackDetailsDataEntity?

    suspend fun getPopularTracks(limit: Int, offset: Int): List<TrackDataEntity>
}