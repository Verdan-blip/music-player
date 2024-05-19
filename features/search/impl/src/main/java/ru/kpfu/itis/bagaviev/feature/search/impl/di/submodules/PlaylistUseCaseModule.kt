package ru.kpfu.itis.bagaviev.feature.search.impl.di.submodules

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import ru.kpfu.itis.bagaviev.common.di.modules.CoroutineDispatcherModule
import ru.kpfu.itis.bagaviev.common.di.modules.IODispatcher
import ru.kpfu.itis.bagaviev.feature.search.api.domain.playlists.repository.PlaylistRepository
import ru.kpfu.itis.bagaviev.feature.search.api.domain.playlists.usecase.GetPlaylistDetailsByIdUseCase

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