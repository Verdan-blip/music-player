package ru.kpfu.itis.bagaviev.data.music.impl.data.search.service.mocked

import ru.kpfu.itis.bagaviev.data.music.impl.data.search.pojo.responses.SearchResultResponse
import ru.kpfu.itis.bagaviev.data.music.impl.data.search.service.SearchApiService
import javax.inject.Inject

class MockedSearchApiService @Inject constructor() : SearchApiService {

    override fun search(keywords: String, limit: Int, offset: Int): SearchResultResponse =
        SearchResultResponse(
            listOf(), listOf(), listOf()
        )
}