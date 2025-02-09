package ru.kpfu.itis.bagaviev.data.music.impl.data.local.music.di.submodules

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import ru.kpfu.itis.bagaviev.data.music.impl.data.local.music.database.DownloadedMusicDatabase

@Module
class MusicDatabaseModule {

    @Provides
    fun provideMusicCacheDatabase(context: Context): DownloadedMusicDatabase =
        Room.databaseBuilder(context, DownloadedMusicDatabase::class.java, "music-cache")
            .build()
}