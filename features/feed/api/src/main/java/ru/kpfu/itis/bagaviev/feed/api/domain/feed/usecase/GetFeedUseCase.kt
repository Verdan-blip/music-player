package ru.kpfu.itis.bagaviev.feed.api.domain.feed.usecase

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import ru.kpfu.itis.bagaviev.feed.api.domain.feed.entity.Feed
import ru.kpfu.itis.bagaviev.feed.api.domain.feed.repository.FeedRepository

class GetFeedUseCase(
    private val feedRepository: FeedRepository,
    private val coroutineDispatcher: CoroutineDispatcher
) {

    suspend operator fun invoke(): Result<Feed> =
        coroutineDispatcher.runCatching {
            withContext(coroutineDispatcher) {
                feedRepository.getFeed()
            }
        }

}