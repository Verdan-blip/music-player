package ru.kpfu.itis.bagaviev.features.profile

import ru.kpfu.itis.bagaviev.data.music.api.data.local.token.repository.TokenDataRepository
import ru.kpfu.itis.bagaviev.feature.profile.domain.repository.FeatureProfileAuthRepository
import javax.inject.Inject

class AdapterFeatureProfileAuthRepository @Inject constructor(
    private val tokenDataRepository: TokenDataRepository
) : FeatureProfileAuthRepository {

    override suspend fun isAuthenticated(): Boolean {
        val access = tokenDataRepository.getAccessToken()
        val refresh = tokenDataRepository.getRefreshToken()
        return access != null &&
                refresh != null
    }
}