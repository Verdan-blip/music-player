package ru.kpfu.itis.bagaviev.features.search.di.submodules

import dagger.Binds
import dagger.Module
import ru.kpfu.itis.bagaviev.feature.search.api.domain.playlists.repository.FeatureSearchPlaylistRepository
import ru.kpfu.itis.bagaviev.feature.search.api.domain.search.repository.FeatureSearchSearchRepository
import ru.kpfu.itis.bagaviev.feature.search.api.domain.track.repository.FeatureSearchTrackRepository
import ru.kpfu.itis.bagaviev.features.search.AdapterFeatureSearchPlaylistRepository
import ru.kpfu.itis.bagaviev.features.search.AdapterFeatureSearchSearchRepository
import ru.kpfu.itis.bagaviev.features.search.AdapterFeatureSearchTrackRepository

@Module
interface FeatureSearchRepositoryModule {

    @Binds
    fun provideAdapterSearchRepository_to_SearchRepository(
        adapterSearchRepository: AdapterFeatureSearchSearchRepository
    ): FeatureSearchSearchRepository

    @Binds
    fun provideAdapterPlaylistRepository_to_PlaylistRepository(
        adapterPlaylistRepository: AdapterFeatureSearchPlaylistRepository
    ): FeatureSearchPlaylistRepository

    @Binds
    fun provideAdapterTrackRepository_to_TrackRepository(
        adapterTrackRepository: AdapterFeatureSearchTrackRepository
    ): FeatureSearchTrackRepository
}