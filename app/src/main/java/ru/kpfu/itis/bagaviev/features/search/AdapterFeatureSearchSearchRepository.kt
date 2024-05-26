package ru.kpfu.itis.bagaviev.features.search

import ru.kpfu.itis.bagaviev.data.music.api.data.network.search.repository.SearchDataRepository
import ru.kpfu.itis.bagaviev.feature.search.api.domain.search.entity.SearchResult
import ru.kpfu.itis.bagaviev.feature.search.api.domain.search.repository.FeatureSearchSearchRepository
import ru.kpfu.itis.bagaviev.features.search.mapper.toSearchResult
import javax.inject.Inject

class AdapterFeatureSearchSearchRepository @Inject constructor(
    private val searchDataRepository: SearchDataRepository
) : FeatureSearchSearchRepository {

    override suspend fun searchByKeywords(
        keywords: List<String>
    ): SearchResult =
        searchDataRepository.searchByKeywords(keywords)
            .toSearchResult()
}