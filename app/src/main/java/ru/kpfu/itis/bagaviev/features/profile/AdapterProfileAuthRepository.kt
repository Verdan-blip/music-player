package ru.kpfu.itis.bagaviev.features.profile

import ru.kpfu.itis.bagaviev.data.music.api.data.local.repository.TokenDataRepository
import ru.kpfu.itis.bagaviev.feature.profile.domain.repository.ProfileAuthRepository
import javax.inject.Inject

class AdapterProfileAuthRepository @Inject constructor(
    private val tokenDataRepository: TokenDataRepository
) : ProfileAuthRepository {

    override suspend fun isAuthenticated(): Boolean {
        val access = tokenDataRepository.getAccessToken()
        val refresh = tokenDataRepository.getRefreshToken()
        return access != null &&
                refresh != null
    }
}