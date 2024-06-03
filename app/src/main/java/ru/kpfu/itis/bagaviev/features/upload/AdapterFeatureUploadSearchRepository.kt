package ru.kpfu.itis.bagaviev.features.upload

import ru.kpfu.itis.bagaviev.data.music.api.data.network.user.repository.UserDataRepository
import ru.kpfu.itis.bagaviev.feature.upload.domain.entity.AuthorFeed
import ru.kpfu.itis.bagaviev.feature.upload.domain.repository.FeatureUploadSearchRepository
import ru.kpfu.itis.bagaviev.features.upload.mapper.toUser
import javax.inject.Inject

class AdapterFeatureUploadSearchRepository @Inject constructor(
    private val userDataRepository: UserDataRepository
) : FeatureUploadSearchRepository {

    override suspend fun searchUsersByKeywords(keywords: List<String>): List<AuthorFeed> =
        userDataRepository.searchUsersByKeywords(keywords).map {
            userDataEntity -> userDataEntity.toUser()
        }
}