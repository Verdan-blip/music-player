package ru.kpfu.itis.bagaviev.data.music.impl.data.playlists.di

import dagger.Binds
import dagger.Module
import ru.kpfu.itis.bagaviev.data.music.api.data.playlists.repository.PlaylistsDataRepository
import ru.kpfu.itis.bagaviev.data.music.impl.data.playlists.repository.PlaylistDataRepositoryImpl
import ru.kpfu.itis.bagaviev.data.music.impl.data.playlists.service.PlaylistApiService
import ru.kpfu.itis.bagaviev.data.music.impl.data.playlists.service.mocked.MockedPlaylistApiService

@Module
internal interface MusicPlaylistDataModule {

    @Binds
    fun providePlaylistDataRepositoryImpl_to_PlaylistDataRepository(
        playlistDataRepositoryImpl: PlaylistDataRepositoryImpl
    ): PlaylistsDataRepository

    @Binds
    fun provideMockedPlaylistApiService_to_PlaylistApiService(
        mockedPlaylistApiService: MockedPlaylistApiService
    ): PlaylistApiService
}