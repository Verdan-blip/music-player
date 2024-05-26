package ru.kpfu.itis.bagaviev.feed.impl.di.submodules

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import ru.kpfu.itis.bagaviev.common.di.modules.CoroutineDispatcherModule
import ru.kpfu.itis.bagaviev.common.di.modules.IODispatcher
import ru.kpfu.itis.bagaviev.feed.api.domain.feed.repository.FeatureFeedFeedRepository
import ru.kpfu.itis.bagaviev.feed.api.domain.feed.usecase.GetFeedUseCase
import ru.kpfu.itis.bagaviev.feed.api.domain.playlist.repository.FeatureFeedPlaylistRepository
import ru.kpfu.itis.bagaviev.feed.api.domain.playlist.usecases.GetPlaylistDetailsByIdUseCase
import ru.kpfu.itis.bagaviev.feed.api.domain.track.repository.FeatureFeedTrackRepository
import ru.kpfu.itis.bagaviev.feed.api.domain.track.usecase.GetTrackDetailsByIdUseCase

@Module(
    includes = [
        CoroutineDispatcherModule::class
    ]
)
internal class UseCaseModule {

    @Provides
    fun provideGetFeedUseCase(
        featureFeedFeedRepository: FeatureFeedFeedRepository,
        @IODispatcher coroutineDispatcher: CoroutineDispatcher
    ): GetFeedUseCase =
        GetFeedUseCase(featureFeedFeedRepository, coroutineDispatcher)

    @Provides
    fun provideGetPlaylistDetailsByIdUseCase(
        featureFeedPlaylistRepository: FeatureFeedPlaylistRepository,
        @IODispatcher coroutineDispatcher: CoroutineDispatcher
    ): GetPlaylistDetailsByIdUseCase =
        GetPlaylistDetailsByIdUseCase(featureFeedPlaylistRepository, coroutineDispatcher)

    @Provides
    fun provideGetTrackDetailsByIdUseCase(
        featureFeedTrackRepository: FeatureFeedTrackRepository,
        @IODispatcher coroutineDispatcher: CoroutineDispatcher
    ): GetTrackDetailsByIdUseCase =
        GetTrackDetailsByIdUseCase(featureFeedTrackRepository, coroutineDispatcher)
}