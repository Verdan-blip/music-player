package ru.kpfu.itis.bagaviev.data.music.impl.data.local.music.repository

import ru.kpfu.itis.bagaviev.data.music.api.data.local.music.entity.DownloadedTrackDataEntity
import ru.kpfu.itis.bagaviev.data.music.api.data.local.music.repository.DownloadedTrackDataRepository
import ru.kpfu.itis.bagaviev.data.music.impl.data.local.music.dao.TrackDao
import ru.kpfu.itis.bagaviev.data.music.impl.data.local.music.mapper.toDownloadedTrackDataEntity
import ru.kpfu.itis.bagaviev.data.music.impl.data.local.music.mapper.toDownloadedTrackDbEntity
import javax.inject.Inject

class DownloadedTrackDataRepositoryImpl @Inject constructor(
    private val trackDao: TrackDao
) : DownloadedTrackDataRepository {

    override suspend fun getAllCachedTracks(): List<DownloadedTrackDataEntity> =
        trackDao.getAllSavedTracks()
            .map { trackWithUsers -> trackWithUsers.toDownloadedTrackDataEntity() }

    override suspend fun insert(downloadedTrackDataEntity: DownloadedTrackDataEntity) {
        trackDao.insertTrack(downloadedTrackDataEntity.toDownloadedTrackDbEntity())
    }
}