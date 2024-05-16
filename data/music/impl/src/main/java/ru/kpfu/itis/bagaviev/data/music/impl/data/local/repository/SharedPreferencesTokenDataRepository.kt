package ru.kpfu.itis.bagaviev.data.music.impl.data.local.repository

import ru.kpfu.itis.bagaviev.data.music.api.data.local.repository.TokenDataRepository
import ru.kpfu.itis.bagaviev.data.music.impl.data.local.datasource.TokenDataSource
import javax.inject.Inject

class SharedPreferencesTokenDataRepository @Inject constructor(
    private val tokenDataSource: TokenDataSource
) : TokenDataRepository {

    override suspend fun saveAccessToken(accessToken: String) {
        tokenDataSource.saveAccessToken(accessToken)
    }

    override suspend fun saveRefreshToken(refreshToken: String) {
        tokenDataSource.saveRefreshToken(refreshToken)
    }

    override suspend fun getAccessToken(): String? =
        tokenDataSource.getAccessToken()

    override suspend fun getRefreshToken(): String? =
        tokenDataSource.getRefreshToken()
}