package ru.kpfu.itis.bagaviev.data.music.impl.data.network.track.di

import dagger.Binds
import dagger.Module
import ru.kpfu.itis.bagaviev.data.music.api.data.network.track.repository.TracksDataRepository
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.track.repository.TrackDataRepositoryImpl
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.track.service.TrackApiService
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.track.service.mocked.MockedTrackApiService

@Module
internal interface TrackDataModule {

    @Binds
    fun provideTracksDataRepositoryImpl_to_TrackDataRepository(
        trackDataRepositoryImpl: TrackDataRepositoryImpl
    ): TracksDataRepository

    @Binds
    fun provideMockedTrackApiService_to_TrackApiService(
        mockedTrackApiService: MockedTrackApiService
    ): TrackApiService
}