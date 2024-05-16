package ru.kpfu.itis.bagaviev.data.music.api.data.network.search.repository

import ru.kpfu.itis.bagaviev.data.music.api.data.network.search.entities.SearchResultDataEntity

interface SearchDataRepository {

    suspend fun searchAnythingByKeywords(
        keywords: List<String>, limit: Int, offset: Int
    ): SearchResultDataEntity
}