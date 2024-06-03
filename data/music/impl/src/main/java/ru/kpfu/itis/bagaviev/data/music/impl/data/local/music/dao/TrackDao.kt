package ru.kpfu.itis.bagaviev.data.music.impl.data.local.music.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import ru.kpfu.itis.bagaviev.data.music.impl.data.local.music.entity.DownloadedTrackDbEntity
import ru.kpfu.itis.bagaviev.data.music.impl.data.local.music.entity.TrackWithUsers

@Dao
interface TrackDao {

    @Transaction
    @Query("SELECT * FROM tracks")
    suspend fun getAllSavedTracks(): List<TrackWithUsers>

    @Insert
    suspend fun insertTrack(downloadedTrackDbEntity: DownloadedTrackDbEntity)
}