package ru.kpfu.itis.bagaviev.data.music.impl.data.local.music.di

import dagger.Module
import ru.kpfu.itis.bagaviev.data.music.impl.data.local.music.di.submodules.DownloadedTrackDaoModule
import ru.kpfu.itis.bagaviev.data.music.impl.data.local.music.di.submodules.DownloadedTrackRepositoryModule
import ru.kpfu.itis.bagaviev.data.music.impl.data.local.music.di.submodules.MusicDatabaseModule

@Module(
    includes = [
        MusicDatabaseModule::class,
        DownloadedTrackRepositoryModule::class,
        DownloadedTrackDaoModule::class
    ]
)
interface DownloadedMusicModule