package ru.kpfu.itis.bagaviev.data.music.impl.data.tracks.di

import dagger.Binds
import dagger.Module
import ru.kpfu.itis.bagaviev.data.music.api.data.tracks.repository.TracksDataRepository
import ru.kpfu.itis.bagaviev.data.music.impl.data.tracks.repository.TrackDataRepositoryImpl
import ru.kpfu.itis.bagaviev.data.music.impl.data.tracks.service.TrackApiService
import ru.kpfu.itis.bagaviev.data.music.impl.data.tracks.service.mocked.MockedTrackApiService

@Module
internal interface MusicTrackDataModule {

    @Binds
    fun provideTrackDataRepositoryImpl_to_TrackDataRepository(
        trackDataRepositoryImpl: TrackDataRepositoryImpl
    ): TracksDataRepository

    @Binds
    fun provideMockedTrackApiService_to_MockedTrackApiService(
        mockedTrackApiService: MockedTrackApiService
    ): TrackApiService
}