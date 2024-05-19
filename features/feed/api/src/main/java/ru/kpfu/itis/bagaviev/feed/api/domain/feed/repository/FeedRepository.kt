package ru.kpfu.itis.bagaviev.feed.api.domain.feed.repository

import ru.kpfu.itis.bagaviev.feed.api.domain.feed.entity.Feed

interface FeedRepository {

    suspend fun getFeed(): Feed
}