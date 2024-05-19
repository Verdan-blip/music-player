package ru.kpfu.itis.bagaviev.data.music.impl.data.network.search.repository

import ru.kpfu.itis.bagaviev.data.music.api.data.network.search.entity.SearchResultDataEntity
import ru.kpfu.itis.bagaviev.data.music.api.data.network.search.repository.SearchDataRepository
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.search.mappers.toSearchResultDataEntity
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.search.service.SearchApiService
import javax.inject.Inject

class SearchDataRepositoryImpl @Inject constructor(
    private val searchApiService: SearchApiService
) : SearchDataRepository {

    override suspend fun searchByKeywords(keywords: List<String>): SearchResultDataEntity =
        searchApiService.search(keywords.joinToString("+"))
            .toSearchResultDataEntity()
}