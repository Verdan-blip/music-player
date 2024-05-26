package ru.kpfu.itis.bagaviev.data.music.impl.data.local.music.repository

import ru.kpfu.itis.bagaviev.data.music.api.data.local.music.repository.CachedTrackRepository
import ru.kpfu.itis.bagaviev.data.music.api.data.network.track.entity.TrackDataEntity
import ru.kpfu.itis.bagaviev.data.music.impl.data.local.music.dao.TrackDao
import ru.kpfu.itis.bagaviev.data.music.impl.data.local.music.mapper.toTrackDataEntity
import ru.kpfu.itis.bagaviev.data.music.impl.data.local.music.mapper.toTrackDbEntity
import javax.inject.Inject

class CachedTrackRepositoryImpl @Inject constructor(
    private val trackDao: TrackDao
) : CachedTrackRepository {

    override suspend fun getAllCachedTracks(): List<TrackDataEntity> =
        trackDao.getAllSavedTracks()
            .map { trackWithUsers -> trackWithUsers.toTrackDataEntity() }

    override suspend fun insert(trackDataEntity: TrackDataEntity) {
        trackDao.insertTrack(trackDataEntity.toTrackDbEntity())
    }
}