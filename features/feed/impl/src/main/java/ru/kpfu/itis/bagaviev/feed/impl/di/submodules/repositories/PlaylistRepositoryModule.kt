package ru.kpfu.itis.bagaviev.feed.impl.di.submodules.repositories

import dagger.Binds
import dagger.Module
import ru.kpfu.itis.bagaviev.feed.api.domain.playlist.repository.PlaylistRepository
import ru.kpfu.itis.bagaviev.feed.impl.data.playlist.repository.PlaylistRepositoryImpl

@Module
internal interface PlaylistRepositoryModule {

    @Binds
    fun providePlaylistRepository_to_PlaylistRepositoryImpl(
        playlistRepositoryImpl: PlaylistRepositoryImpl
    ): PlaylistRepository
}