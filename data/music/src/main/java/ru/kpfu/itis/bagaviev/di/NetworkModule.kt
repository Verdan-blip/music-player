package ru.kpfu.itis.bagaviev.di

import dagger.Module
import dagger.Provides
import ru.kpfu.itis.bagaviev.data.playlists.entities.responses.PlaylistDetailsResponseEntity
import ru.kpfu.itis.bagaviev.data.playlists.entities.responses.PlaylistResponseEntity
import ru.kpfu.itis.bagaviev.data.playlists.service.PlaylistApiService
import ru.kpfu.itis.bagaviev.data.playlists.service.mocked.MockedPlaylistApiService
import ru.kpfu.itis.bagaviev.data.tracks.entities.responses.TrackDetailsResponseEntity
import ru.kpfu.itis.bagaviev.data.tracks.entities.responses.TrackResponseEntity
import ru.kpfu.itis.bagaviev.data.tracks.service.TrackApiService
import ru.kpfu.itis.bagaviev.data.tracks.service.mocked.MockedTrackApiService
import ru.kpfu.itis.bagaviev.data.users.entites.responses.UserResponseEntity

@Module
class NetworkModule {

    @Provides
    fun provideTrackApiService(): TrackApiService = MockedTrackApiService()

    @Provides
    fun providePlaylistApiService(): PlaylistApiService = MockedPlaylistApiService()
}