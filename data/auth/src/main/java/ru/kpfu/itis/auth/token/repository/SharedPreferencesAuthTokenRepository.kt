package ru.kpfu.itis.auth.token.repository

import ru.kpfu.itis.auth.datasources.DataSource
import javax.inject.Inject

class SharedPreferencesAuthTokenRepository @Inject constructor(
    private val dataSource: DataSource
) : AuthTokenRepository {

    override fun saveAccessToken(accessToken: String) {
        dataSource.putString(ACCESS_TOKEN_NAME, accessToken)
    }

    override fun getAccessToken(): String? =
        dataSource.getString(ACCESS_TOKEN_NAME)

    override fun saveRefreshToken(refreshToken: String) {
        dataSource.putString(REFRESH_TOKEN_NAME, refreshToken)
    }

    override fun getRefreshToken(): String? =
        dataSource.getString(REFRESH_TOKEN_NAME)

    companion object {
        const val ACCESS_TOKEN_NAME = "access_token"
        const val REFRESH_TOKEN_NAME = "refresh_token"
    }
}