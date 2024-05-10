package ru.kpfu.itis.bagaviev.data.music.api.data.search.repository

import ru.kpfu.itis.bagaviev.data.music.api.data.search.entities.SearchResultDataEntity

interface SearchDataRepository {

    suspend fun searchAnythingByKeywords(
        keywords: List<String>, limit: Int, offset: Int
    ): SearchResultDataEntity
}