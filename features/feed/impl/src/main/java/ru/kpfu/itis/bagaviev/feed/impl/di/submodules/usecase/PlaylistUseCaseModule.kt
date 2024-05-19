package ru.kpfu.itis.bagaviev.feed.impl.di.submodules.usecase

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import ru.kpfu.itis.bagaviev.common.di.modules.CoroutineDispatcherModule
import ru.kpfu.itis.bagaviev.common.di.modules.IODispatcher
import ru.kpfu.itis.bagaviev.feed.api.domain.playlist.repository.PlaylistRepository
import ru.kpfu.itis.bagaviev.feed.api.domain.playlist.usecases.GetPlaylistDetailsByIdUseCase

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
}