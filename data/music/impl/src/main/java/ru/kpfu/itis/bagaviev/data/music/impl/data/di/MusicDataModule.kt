package ru.kpfu.itis.bagaviev.data.music.impl.data.di

import dagger.Module
import ru.kpfu.itis.bagaviev.data.music.impl.data.playlists.di.MusicPlaylistDataModule
import ru.kpfu.itis.bagaviev.data.music.impl.data.search.di.MusicSearchModule
import ru.kpfu.itis.bagaviev.data.music.impl.data.tracks.di.MusicTrackDataModule

@Module(
    includes = [
        MusicPlaylistDataModule::class,
        MusicTrackDataModule::class,
        MusicSearchModule::class
    ]
)
interface MusicDataModule