package ru.kpfu.itis.bagaviev.feed.impl.di.submodules.repositories

import dagger.Binds
import dagger.Module
import ru.kpfu.itis.bagaviev.feed.api.domain.track.repository.TrackRepository
import ru.kpfu.itis.bagaviev.feed.impl.data.track.repository.TrackRepositoryImpl

@Module
internal interface TrackRepositoryModule {

    @Binds
    fun provideTrackRepository_toTrackRepositoryImpl(
        trackRepositoryImpl: TrackRepositoryImpl
    ): TrackRepository
}