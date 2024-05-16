package ru.kpfu.itis.bagaviev.data.music.impl.data.network.playlist.di

import dagger.Binds
import dagger.Module
import ru.kpfu.itis.bagaviev.data.music.api.data.network.playlist.repository.PlaylistsDataRepository
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.playlist.repository.PlaylistDataRepositoryImpl
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.playlist.service.PlaylistApiService
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.playlist.service.mocked.MockedPlaylistApiService

@Module
internal interface PlaylistDataModule {

    @Binds
    fun providePlaylistDataRepositoryImpl_to_PlaylistDataRepository(
        playlistDataRepositoryImpl: PlaylistDataRepositoryImpl
    ): PlaylistsDataRepository

    @Binds
    fun provideMockedPlaylistApiService_to_PlaylistApiService(
        mockedPlaylistApiService: MockedPlaylistApiService
    ): PlaylistApiService
}