package ru.kpfu.itis.bagaviev.data.music.api.data.local.music.repository

import ru.kpfu.itis.bagaviev.data.music.api.data.network.track.entity.TrackDataEntity

interface CachedTrackRepository {

    suspend fun getAllCachedTracks(): List<TrackDataEntity>

    suspend fun insert(trackDataEntity: TrackDataEntity)
}