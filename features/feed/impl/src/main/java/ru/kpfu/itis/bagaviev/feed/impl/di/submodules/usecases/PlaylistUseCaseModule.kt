package ru.kpfu.itis.bagaviev.feed.impl.di.submodules.usecases

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import ru.kpfu.itis.bagaviev.common.di.modules.CoroutineDispatcherModule
import ru.kpfu.itis.bagaviev.common.di.modules.IODispatcher
import ru.kpfu.itis.bagaviev.feed.api.domain.playlists.repository.PlaylistRepository
import ru.kpfu.itis.bagaviev.feed.api.domain.playlists.usecases.GetPlaylistDetailsByIdUseCase
import ru.kpfu.itis.bagaviev.feed.api.domain.playlists.usecases.GetPopularPlaylistsUseCase

@Module(
    includes = [CoroutineDispatcherModule::class]
)
internal class PlaylistUseCaseModule {

    @Provides
    fun provideGetPlaylistDetailsByIdUseCase(
        playlistRepository: PlaylistRepository,
        @IODispatcher coroutineDispatcher: CoroutineDispatcher
    ): GetPlaylistDetailsByIdUseCase =
        GetPlaylistDetailsByIdUseCase(playlistRepository, coroutineDispatcher)

    @Provides
    fun providePopularPlaylistsUseCase(
        playlistRepository: PlaylistRepository,
        @IODispatcher coroutineDispatcher: CoroutineDispatcher
    ): GetPopularPlaylistsUseCase =
        GetPopularPlaylistsUseCase(playlistRepository, coroutineDispatcher)
}