package ru.kpfu.itis.bagaviev.features.feed

import ru.kpfu.itis.bagaviev.data.music.api.data.network.feed.repository.FeedDataRepository
import ru.kpfu.itis.bagaviev.feed.api.domain.feed.entity.Feed
import ru.kpfu.itis.bagaviev.feed.api.domain.feed.repository.FeatureFeedFeedRepository
import ru.kpfu.itis.bagaviev.features.feed.mapper.toFeed
import javax.inject.Inject

class AdapterFeatureFeedFeedRepository @Inject constructor(
    private val feedDataRepository: FeedDataRepository
) : FeatureFeedFeedRepository {

    override suspend fun getFeed(): Feed =
        feedDataRepository.getFeed().toFeed()
}