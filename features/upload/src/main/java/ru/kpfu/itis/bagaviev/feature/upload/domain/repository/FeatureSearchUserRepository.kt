package ru.kpfu.itis.bagaviev.feature.upload.domain.repository

import ru.kpfu.itis.bagaviev.feature.upload.domain.entity.User

interface FeatureSearchUserRepository {

    suspend fun searchUsersByKeywords(keywords: List<String>): List<User>
}