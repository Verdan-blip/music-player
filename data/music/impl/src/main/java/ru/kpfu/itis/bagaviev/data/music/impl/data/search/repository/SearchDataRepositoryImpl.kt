package ru.kpfu.itis.bagaviev.data.music.impl.data.search.repository

import ru.kpfu.itis.bagaviev.data.music.api.data.search.entities.SearchResultDataEntity
import ru.kpfu.itis.bagaviev.data.music.api.data.search.repository.SearchDataRepository
import ru.kpfu.itis.bagaviev.data.music.impl.data.search.mappers.toSearchResultDataEntity
import ru.kpfu.itis.bagaviev.data.music.impl.data.search.service.SearchApiService
import javax.inject.Inject

class SearchDataRepositoryImpl @Inject constructor(
    private val searchApiService: SearchApiService
) : SearchDataRepository {

    override suspend fun searchAnythingByKeywords(
        keywords: List<String>,
        limit: Int,
        offset: Int
    ): SearchResultDataEntity =
        searchApiService.search(keywords.joinToString("+"), limit, offset)
            .toSearchResultDataEntity()
}