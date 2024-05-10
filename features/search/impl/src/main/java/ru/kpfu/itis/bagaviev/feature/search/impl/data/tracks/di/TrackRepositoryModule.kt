package ru.kpfu.itis.bagaviev.feature.search.impl.data.tracks.di

import dagger.Binds
import dagger.Module
import ru.kpfu.itis.bagaviev.feature.search.api.domain.tracks.repository.TrackRepository
import ru.kpfu.itis.bagaviev.feature.search.impl.data.tracks.repository.TrackRepositoryImpl

@Module
internal interface TrackRepositoryModule {

    @Binds
    fun provideTrackRepositoryImpl_toTrackRepository(
        trackRepositoryImpl: TrackRepositoryImpl
    ): TrackRepository
}