package ru.kpfu.itis.bagaviev.feed.impl.di.submodules.usecase

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import ru.kpfu.itis.bagaviev.common.di.modules.IODispatcher
import ru.kpfu.itis.bagaviev.feed.api.domain.feed.repository.FeedRepository
import ru.kpfu.itis.bagaviev.feed.api.domain.feed.usecase.GetFeedUseCase

@Module
class FeedUseCaseModule {

    @Provides
    fun provideGetFeedUseCase(
        feedRepository: FeedRepository,
        @IODispatcher coroutineDispatcher: CoroutineDispatcher
    ): GetFeedUseCase =
        GetFeedUseCase(feedRepository, coroutineDispatcher)
}