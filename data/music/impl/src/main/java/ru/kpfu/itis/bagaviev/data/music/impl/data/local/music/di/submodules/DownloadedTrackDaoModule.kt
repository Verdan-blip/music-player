package ru.kpfu.itis.bagaviev.data.music.impl.data.local.music.di.submodules

import dagger.Module
import dagger.Provides
import ru.kpfu.itis.bagaviev.data.music.impl.data.local.music.dao.TrackDao
import ru.kpfu.itis.bagaviev.data.music.impl.data.local.music.database.DownloadedMusicDatabase

@Module
class DownloadedTrackDaoModule {

    @Provides
    fun provideTrackDao(database: DownloadedMusicDatabase): TrackDao =
        database.trackDao
}