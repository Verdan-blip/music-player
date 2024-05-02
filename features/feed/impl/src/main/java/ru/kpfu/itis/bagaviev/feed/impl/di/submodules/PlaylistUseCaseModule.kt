package ru.kpfu.itis.bagaviev.feed.impl.di.submodules

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import ru.kpfu.itis.bagaviev.feed.api.domain.playlists.repository.PlaylistRepository
import ru.kpfu.itis.bagaviev.feed.api.domain.playlists.usecases.GetPlaylistByIdUseCase
import ru.kpfu.itis.bagaviev.feed.api.domain.playlists.usecases.GetPopularPlaylistsUseCase
import ru.kpfu.itis.common.di.modules.CoroutineDispatcherModule
import ru.kpfu.itis.common.di.modules.IODispatcher

@Module(
    includes = [CoroutineDispatcherModule::class]
)
class PlaylistUseCaseModule {

    @Provides
    fun provideGetPlaylistDetailsByIdUseCase(
        playlistRepository: PlaylistRepository,
        @IODispatcher coroutineDispatcher: CoroutineDispatcher
    ): GetPlaylistByIdUseCase =
        GetPlaylistByIdUseCase(playlistRepository, coroutineDispatcher)

    @Provides
    fun providePopularPlaylistsUseCase(
        playlistRepository: PlaylistRepository,
        @IODispatcher coroutineDispatcher: CoroutineDispatcher
    ): GetPopularPlaylistsUseCase =
        GetPopularPlaylistsUseCase(playlistRepository, coroutineDispatcher)
}