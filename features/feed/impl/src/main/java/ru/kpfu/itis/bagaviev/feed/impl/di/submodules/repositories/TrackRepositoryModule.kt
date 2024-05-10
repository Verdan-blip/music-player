package ru.kpfu.itis.bagaviev.feed.impl.di.submodules.repositories

import dagger.Binds
import dagger.Module
import ru.kpfu.itis.bagaviev.feed.api.domain.tracks.repository.TrackRepository
import ru.kpfu.itis.bagaviev.feed.impl.data.tracks.repository.TrackRepositoryImpl

@Module
internal interface TrackRepositoryModule {

    @Binds
    fun provideTrackRepository_toTrackRepositoryImpl(
        trackRepositoryImpl: TrackRepositoryImpl
    ): TrackRepository
}