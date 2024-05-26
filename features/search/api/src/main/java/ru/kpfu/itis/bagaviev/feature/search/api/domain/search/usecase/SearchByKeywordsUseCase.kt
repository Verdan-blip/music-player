package ru.kpfu.itis.bagaviev.feature.search.api.domain.search.usecase

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import ru.kpfu.itis.bagaviev.feature.search.api.domain.search.entity.SearchResult
import ru.kpfu.itis.bagaviev.feature.search.api.domain.search.repository.FeatureSearchSearchRepository

class SearchByKeywordsUseCase(
    private val featureSearchSearchRepository: FeatureSearchSearchRepository,
    private val coroutineDispatcher: CoroutineDispatcher
) {

    suspend operator fun invoke(
        keywords: List<String>
    ): SearchResult =
        withContext(coroutineDispatcher) {
            featureSearchSearchRepository.searchByKeywords(keywords)
        }
}