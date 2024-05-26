package ru.kpfu.itis.bagaviev.feature.search.api.domain.search.repository

import ru.kpfu.itis.bagaviev.feature.search.api.domain.search.entity.SearchResult

interface FeatureSearchSearchRepository {

    suspend fun searchByKeywords(
        keywords: List<String>
    ): SearchResult
}