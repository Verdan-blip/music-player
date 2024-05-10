package ru.kpfu.itis.bagaviev.feature.search.api.domain.search.usecases

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import ru.kpfu.itis.bagaviev.feature.search.api.domain.search.entities.SearchResult
import ru.kpfu.itis.bagaviev.feature.search.api.domain.search.repository.SearchRepository

class SearchAnythingByKeywordsUseCase(
    private val searchRepository: SearchRepository,
    private val coroutineDispatcher: CoroutineDispatcher
) {

    suspend operator fun invoke(
        keywords: List<String>,
        limit: Int = 5,
        offset: Int = 0
    ): SearchResult =
        withContext(coroutineDispatcher) {
            searchRepository.searchAnythingByKeywords(keywords, limit, offset)
        }
}