package ru.kpfu.itis.bagaviev.data.music.api.data.network.feed.repository

import ru.kpfu.itis.bagaviev.data.music.api.data.network.feed.entity.FeedDataEntity

interface FeedDataRepository {

    suspend fun getFeed(): FeedDataEntity
}