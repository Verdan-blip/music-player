package ru.kpfu.itis.bagaviev.feed.impl.di.submodules.usecases

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import ru.kpfu.itis.bagaviev.common.di.modules.CoroutineDispatcherModule
import ru.kpfu.itis.bagaviev.common.di.modules.IODispatcher
import ru.kpfu.itis.bagaviev.feed.api.domain.track.repository.TrackRepository
import ru.kpfu.itis.bagaviev.feed.api.domain.track.usecase.GetPopularTracksUseCase
import ru.kpfu.itis.bagaviev.feed.api.domain.track.usecase.GetTrackDetailsByIdUseCase

@Module(
    includes = [CoroutineDispatcherModule::class]
)
internal class TrackUseCasesModule {

    @Provides
    fun provideGetTrackByIdUseCase(
        trackRepository: TrackRepository,
        @IODispatcher coroutineDispatcher: CoroutineDispatcher
    ): GetPopularTracksUseCase =
        GetPopularTracksUseCase(trackRepository, coroutineDispatcher)

    @Provides
    fun provideGetTrackDetailsByIdUseCase(
        trackRepository: TrackRepository,
        @IODispatcher coroutineDispatcher: CoroutineDispatcher
    ): GetTrackDetailsByIdUseCase =
        GetTrackDetailsByIdUseCase(trackRepository, coroutineDispatcher)
}