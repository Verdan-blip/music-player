package ru.kpfu.itis.bagaviev.glue.feed.di

import dagger.Binds
import dagger.Module
import ru.kpfu.itis.bagaviev.api.domain.playlists.repository.PlaylistRepository
import ru.kpfu.itis.bagaviev.api.domain.repository.MusicControllerRepository
import ru.kpfu.itis.bagaviev.api.domain.tracks.repository.TrackRepository
import ru.kpfu.itis.bagaviev.glue.feed.AdapterPlaylistRepository
import ru.kpfu.itis.bagaviev.glue.feed.AdapterTrackRepository
import ru.kpfu.itis.bagaviev.impl.data.repository.MusicControllerRepositoryImpl

@Module
interface FeedRepositoriesModule {

    @Binds
    fun providePlaylistRepository(
        adapterPlaylistRepository: AdapterPlaylistRepository
    ): PlaylistRepository

    @Binds
    fun provideTrackRepository(
        adapterTrackRepository: AdapterTrackRepository
    ): TrackRepository
}