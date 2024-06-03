package ru.kpfu.itis.bagaviev.feature.upload.domain.repository

import ru.kpfu.itis.bagaviev.feature.upload.domain.entity.AuthorFeed

interface FeatureUploadSearchRepository {

    suspend fun searchUsersByKeywords(keywords: List<String>): List<AuthorFeed>
}