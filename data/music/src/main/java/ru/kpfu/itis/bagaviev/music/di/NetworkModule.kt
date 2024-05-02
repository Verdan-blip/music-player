package ru.kpfu.itis.bagaviev.music.di

import dagger.Module
import dagger.Provides
import ru.kpfu.itis.bagaviev.music.data.playlists.service.PlaylistApiService
import ru.kpfu.itis.bagaviev.music.data.playlists.service.mocked.MockedPlaylistApiService
import ru.kpfu.itis.bagaviev.music.data.tracks.service.TrackApiService
import ru.kpfu.itis.bagaviev.music.data.tracks.service.mocked.MockedTrackApiService

@Module
class NetworkModule {

    @Provides
    fun provideTrackApiService(): TrackApiService = MockedTrackApiService()

    @Provides
    fun providePlaylistApiService(): PlaylistApiService = MockedPlaylistApiService()
}