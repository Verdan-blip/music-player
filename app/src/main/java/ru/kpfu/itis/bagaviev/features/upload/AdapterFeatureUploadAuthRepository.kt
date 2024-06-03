package ru.kpfu.itis.bagaviev.features.upload

import ru.kpfu.itis.bagaviev.data.music.api.data.local.token.repository.TokenDataRepository
import ru.kpfu.itis.bagaviev.data.music.api.data.network.user.repository.UserDataRepository
import ru.kpfu.itis.bagaviev.feature.upload.domain.entity.AuthorFeed
import ru.kpfu.itis.bagaviev.feature.upload.domain.repository.FeatureUploadAuthRepository
import ru.kpfu.itis.bagaviev.features.upload.mapper.toUser
import javax.inject.Inject

class AdapterFeatureUploadAuthRepository @Inject constructor(
    private val tokenDataRepository: TokenDataRepository,
    private val userDataRepository: UserDataRepository
) : FeatureUploadAuthRepository {

    override suspend fun checkIsAuthenticated(): Boolean =
        tokenDataRepository.getAccessToken() != null

    override suspend fun getCurrentUser(): AuthorFeed =
        userDataRepository.getCurrentUserProfile()
            .toUser()
}