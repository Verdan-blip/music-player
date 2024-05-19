package ru.kpfu.itis.bagaviev.feature.search.impl.data.search.repository

import ru.kpfu.itis.bagaviev.data.music.api.data.network.search.repository.SearchDataRepository
import ru.kpfu.itis.bagaviev.feature.search.api.domain.search.entity.SearchResult
import ru.kpfu.itis.bagaviev.feature.search.api.domain.search.repository.SearchRepository
import ru.kpfu.itis.bagaviev.feature.search.impl.data.search.mappers.toSearchResult
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
    private val searchDataRepository: SearchDataRepository
) : SearchRepository {

    override suspend fun searchByKeywords(
        keywords: List<String>
    ): SearchResult =
        searchDataRepository.searchByKeywords(keywords)
            .toSearchResult()
}