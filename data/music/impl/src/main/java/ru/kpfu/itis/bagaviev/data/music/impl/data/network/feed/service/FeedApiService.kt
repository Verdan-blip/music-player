package ru.kpfu.itis.bagaviev.data.music.impl.data.network.feed.service

import retrofit2.http.GET
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.feed.pojo.FeedResponse

interface FeedApiService {

    @GET("/api/v1/feed")
    suspend fun getFeed(): FeedResponse
}