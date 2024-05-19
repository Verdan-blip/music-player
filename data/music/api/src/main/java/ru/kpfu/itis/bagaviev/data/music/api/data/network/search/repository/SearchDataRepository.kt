package ru.kpfu.itis.bagaviev.data.music.api.data.network.search.repository

import ru.kpfu.itis.bagaviev.data.music.api.data.network.search.entity.SearchResultDataEntity

interface SearchDataRepository {

    suspend fun searchByKeywords(
        keywords: List<String>
    ): SearchResultDataEntity
}