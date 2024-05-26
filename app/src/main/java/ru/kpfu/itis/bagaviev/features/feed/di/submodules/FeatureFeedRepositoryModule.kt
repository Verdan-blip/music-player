package ru.kpfu.itis.bagaviev.features.feed.di.submodules

import dagger.Binds
import dagger.Module
import ru.kpfu.itis.bagaviev.features.feed.AdapterFeatureFeedFeedRepository
import ru.kpfu.itis.bagaviev.features.feed.AdapterFeatureFeedPlaylistRepository
import ru.kpfu.itis.bagaviev.features.feed.AdapterFeatureFeedTrackRepository
import ru.kpfu.itis.bagaviev.feed.api.domain.feed.repository.FeatureFeedFeedRepository
import ru.kpfu.itis.bagaviev.feed.api.domain.playlist.repository.FeatureFeedPlaylistRepository
import ru.kpfu.itis.bagaviev.feed.api.domain.track.repository.FeatureFeedTrackRepository

@Module
interface FeatureFeedRepositoryModule {

    @Binds
    fun provideAdapterFeedRepository_to_FeedRepository(
        adapterFeedRepository: AdapterFeatureFeedFeedRepository
    ): FeatureFeedFeedRepository

    @Binds
    fun provideAdapterPlaylistRepository_to_PlaylistRepository(
        adapterPlaylistRepository: AdapterFeatureFeedPlaylistRepository
    ): FeatureFeedPlaylistRepository

    @Binds
    fun provideAdapterTrackRepository(
        adapterTrackRepository: AdapterFeatureFeedTrackRepository
    ): FeatureFeedTrackRepository
}