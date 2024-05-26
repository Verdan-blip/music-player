package ru.kpfu.itis.bagaviev.feed.api.domain.feed.repository

import ru.kpfu.itis.bagaviev.feed.api.domain.feed.entity.Feed

interface FeatureFeedFeedRepository {

    suspend fun getFeed(): Feed
}