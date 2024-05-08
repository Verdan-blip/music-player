package ru.kpfu.itis.bagaviev.glue.feed.di

import dagger.Binds
import dagger.Module
import ru.kpfu.itis.bagaviev.feed.api.domain.playlists.repository.PlaylistRepository
import ru.kpfu.itis.bagaviev.feed.api.domain.tracks.repository.TrackRepository
import ru.kpfu.itis.bagaviev.glue.feed.AdapterPlaylistRepository
import ru.kpfu.itis.bagaviev.glue.feed.AdapterTrackRepository

@Module
interface FeatureFeedRepositoriesModule {

    @Binds
    fun providePlaylistRepository(
        adapterPlaylistRepository: AdapterPlaylistRepository
    ): PlaylistRepository

    @Binds
    fun provideTrackRepository(
        adapterTrackRepository: AdapterTrackRepository
    ): TrackRepository
}