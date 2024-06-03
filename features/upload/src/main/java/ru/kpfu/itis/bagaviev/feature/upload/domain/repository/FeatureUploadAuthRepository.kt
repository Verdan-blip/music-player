package ru.kpfu.itis.bagaviev.feature.upload.domain.repository

import ru.kpfu.itis.bagaviev.feature.upload.domain.entity.AuthorFeed

interface FeatureUploadAuthRepository {

    suspend fun checkIsAuthenticated(): Boolean

    suspend fun getCurrentUser(): AuthorFeed
}