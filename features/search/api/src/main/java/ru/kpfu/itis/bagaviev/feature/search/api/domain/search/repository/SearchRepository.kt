package ru.kpfu.itis.bagaviev.feature.search.api.domain.search.repository

import ru.kpfu.itis.bagaviev.feature.search.api.domain.search.entities.SearchResult

interface SearchRepository {

    suspend fun searchAnythingByKeywords(
        keywords: List<String>,
        limit: Int,
        offset: Int
    ): SearchResult
}