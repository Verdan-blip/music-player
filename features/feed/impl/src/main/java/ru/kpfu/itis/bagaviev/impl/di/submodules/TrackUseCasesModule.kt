package ru.kpfu.itis.bagaviev.impl.di.submodules

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import ru.kpfu.itis.bagaviev.api.domain.tracks.repository.TrackRepository
import ru.kpfu.itis.bagaviev.api.domain.tracks.usecases.GetChartTracksUseCase
import ru.kpfu.itis.bagaviev.api.domain.tracks.usecases.GetTrackDetailsByIdUseCase
import ru.kpfu.itis.common.di.modules.CoroutineDispatcherModule
import ru.kpfu.itis.common.di.modules.IODispatcher

@Module(
    includes = [CoroutineDispatcherModule::class]
)
internal class TrackUseCasesModule {

    @Provides
    fun provideGetTrackByIdUseCase(
        trackRepository: TrackRepository,
        @IODispatcher coroutineDispatcher: CoroutineDispatcher
    ): GetChartTracksUseCase =
        GetChartTracksUseCase(trackRepository, coroutineDispatcher)

    @Provides
    fun provideGetTrackDetailsByIdUseCase(
        trackRepository: TrackRepository,
        @IODispatcher coroutineDispatcher: CoroutineDispatcher
    ): GetTrackDetailsByIdUseCase =
        GetTrackDetailsByIdUseCase(trackRepository, coroutineDispatcher)
}