package ru.kpfu.itis.bagaviev.data.music.impl.data.network.search.service

import retrofit2.http.GET
import retrofit2.http.Query
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.search.pojo.responses.SearchResultResponse

interface SearchApiService {

    @GET("/api/v1/search")
    fun search(
        @Query("keywords") keywords: String,
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): SearchResultResponse
}