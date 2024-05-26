package ru.kpfu.itis.bagaviev.data.music.impl.data.local.music.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import ru.kpfu.itis.bagaviev.data.music.impl.data.local.music.database.MusicCacheDatabase

@Module
class MusicDatabaseModule {

    @Provides
    fun provideMusicCacheDatabase(context: Context): MusicCacheDatabase =
        Room.databaseBuilder(context, MusicCacheDatabase::class.java, "music-cache")
            .build()
}