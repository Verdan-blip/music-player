package ru.kpfu.itis.bagaviev.data.music.impl.data.network.search.repository

import ru.kpfu.itis.bagaviev.data.music.api.data.network.search.entities.SearchResultDataEntity
import ru.kpfu.itis.bagaviev.data.music.api.data.network.search.repository.SearchDataRepository
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.search.mappers.toSearchResultDataEntity
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.search.service.SearchApiService
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