package ru.kpfu.itis.bagaviev.feature.search.impl.data.playlists.di

import dagger.Binds
import dagger.Module
import ru.kpfu.itis.bagaviev.feature.search.api.domain.playlists.repository.PlaylistRepository
import ru.kpfu.itis.bagaviev.feature.search.impl.data.playlists.repository.PlaylistRepositoryImpl

@Module
internal interface PlaylistRepositoryModule {

    @Binds
    fun providePlaylistRepository_to_PlaylistRepositoryImpl(
        playlistRepositoryImpl: PlaylistRepositoryImpl
    ): PlaylistRepository
}