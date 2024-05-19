package ru.kpfu.itis.bagaviev.data.music.impl.data.network.playlist.di.submodules

import dagger.Binds
import dagger.Module
import ru.kpfu.itis.bagaviev.data.music.api.data.network.playlist.repository.PlaylistsDataRepository
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.playlist.repository.PlaylistDataRepositoryImpl

@Module
interface PlaylistRepositoryDataModule {

    @Binds
    fun providePlaylistDataRepositoryImpl_to_PlaylistDataRepository(
        playlistDataRepositoryImpl: PlaylistDataRepositoryImpl
    ): PlaylistsDataRepository
}