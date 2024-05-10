package ru.kpfu.itis.bagaviev.feature.search.impl.data.search.repository

import ru.kpfu.itis.bagaviev.data.music.api.data.search.repository.SearchDataRepository
import ru.kpfu.itis.bagaviev.feature.search.api.domain.search.entities.SearchResult
import ru.kpfu.itis.bagaviev.feature.search.api.domain.search.repository.SearchRepository
import ru.kpfu.itis.bagaviev.feature.search.impl.data.search.mappers.toSearchResult
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
    private val searchDataRepository: SearchDataRepository
) : SearchRepository {

    override suspend fun searchAnythingByKeywords(
        keywords: List<String>, limit: Int, offset: Int
    ): SearchResult =
        searchDataRepository.searchAnythingByKeywords(keywords, limit, offset)
            .toSearchResult()
}