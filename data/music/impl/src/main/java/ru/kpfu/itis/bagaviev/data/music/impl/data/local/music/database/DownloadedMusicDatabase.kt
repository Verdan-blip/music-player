package ru.kpfu.itis.bagaviev.data.music.impl.data.local.music.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.kpfu.itis.bagaviev.data.music.impl.data.local.music.dao.TrackDao
import ru.kpfu.itis.bagaviev.data.music.impl.data.local.music.entity.DownloadedTrackDbEntity
import ru.kpfu.itis.bagaviev.data.music.impl.data.local.music.entity.TrackUserCrossRef
import ru.kpfu.itis.bagaviev.data.music.impl.data.local.music.entity.UserDbEntity

@Database(
    entities = [
        DownloadedTrackDbEntity::class,
        UserDbEntity::class,
        TrackUserCrossRef::class
    ],
    version = 1
)
abstract class DownloadedMusicDatabase : RoomDatabase() {

    abstract val trackDao: TrackDao
}