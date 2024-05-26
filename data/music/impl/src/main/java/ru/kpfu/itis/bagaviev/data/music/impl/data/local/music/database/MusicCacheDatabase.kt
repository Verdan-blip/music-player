package ru.kpfu.itis.bagaviev.data.music.impl.data.local.music.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.kpfu.itis.bagaviev.data.music.impl.data.local.music.dao.TrackDao
import ru.kpfu.itis.bagaviev.data.music.impl.data.local.music.entity.TrackDbEntity
import ru.kpfu.itis.bagaviev.data.music.impl.data.local.music.entity.TrackUserCrossRef
import ru.kpfu.itis.bagaviev.data.music.impl.data.local.music.entity.UserDbEntity

@Database(
    entities = [
        TrackDbEntity::class,
        UserDbEntity::class,
        TrackUserCrossRef::class
    ],
    version = 1
)
abstract class MusicCacheDatabase : RoomDatabase() {

    abstract val trackDao: TrackDao
}