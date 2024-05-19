package ru.kpfu.itis.bagaviev.feed.impl.data.feed.repository

import ru.kpfu.itis.bagaviev.data.music.api.data.network.feed.repository.FeedDataRepository
import ru.kpfu.itis.bagaviev.feed.api.domain.feed.entity.Feed
import ru.kpfu.itis.bagaviev.feed.api.domain.feed.repository.FeedRepository
import ru.kpfu.itis.bagaviev.feed.impl.data.feed.mapper.toFeed
import javax.inject.Inject

class FeedRepositoryImpl @Inject constructor(
    private val feedDataRepository: FeedDataRepository
) : FeedRepository {

    override suspend fun getFeed(): Feed =
        feedDataRepository.getFeed().toFeed()
}