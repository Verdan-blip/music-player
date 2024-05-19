package ru.kpfu.itis.bagaviev.data.music.impl.data.network.feed.repository

import ru.kpfu.itis.bagaviev.data.music.api.data.network.feed.entity.FeedDataEntity
import ru.kpfu.itis.bagaviev.data.music.api.data.network.feed.repository.FeedDataRepository
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.feed.mapper.toFeedDataEntity
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.feed.service.FeedApiService
import javax.inject.Inject

class FeedDataRepositoryImpl @Inject constructor(
    private val feedApiService: FeedApiService
) : FeedDataRepository {

    override suspend fun getFeed(): FeedDataEntity =
        feedApiService.getFeed().toFeedDataEntity()
}