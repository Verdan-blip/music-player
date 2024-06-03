package ru.kpfu.itis.bagaviev.data.music.api.data.local.music.repository

import ru.kpfu.itis.bagaviev.data.music.api.data.local.music.entity.DownloadedTrackDataEntity

interface DownloadedTrackDataRepository {

    suspend fun getAllCachedTracks(): List<DownloadedTrackDataEntity>

    suspend fun insert(downloadedTrackDataEntity: DownloadedTrackDataEntity)
}