package ru.kpfu.itis.bagaviev.feature.search.api.domain.search.usecase

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import ru.kpfu.itis.bagaviev.feature.search.api.domain.search.entity.SearchResult
import ru.kpfu.itis.bagaviev.feature.search.api.domain.search.repository.SearchRepository

class SearchByKeywordsUseCase(
    private val searchRepository: SearchRepository,
    private val coroutineDispatcher: CoroutineDispatcher
) {

    suspend operator fun invoke(
        keywords: List<String>
    ): SearchResult =
        withContext(coroutineDispatcher) {
            searchRepository.searchByKeywords(keywords)
        }
}