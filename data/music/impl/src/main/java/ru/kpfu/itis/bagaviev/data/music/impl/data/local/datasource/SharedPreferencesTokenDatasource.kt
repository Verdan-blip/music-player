package ru.kpfu.itis.bagaviev.data.music.impl.data.local.datasource

import android.content.Context
import androidx.core.content.edit
import javax.inject.Inject

class SharedPreferencesTokenDatasource @Inject constructor(
    context: Context
) : TokenDataSource {

    private val sharedPreferences = context.getSharedPreferences(
        TOKEN_SHARED_PREFERENCES_NAME,
        Context.MODE_PRIVATE
    )

    override fun getAccessToken(): String? =
        sharedPreferences.getString(ACCESS_TOKEN_NAME, null)

    override fun getRefreshToken(): String? =
        sharedPreferences.getString(REFRESH_TOKEN_NAME, null)

    override fun saveAccessToken(accessToken: String) {
        sharedPreferences.edit {
            putString(ACCESS_TOKEN_NAME, accessToken)
        }
    }

    override fun saveRefreshToken(refreshToken: String) {
        sharedPreferences.edit {
            putString(REFRESH_TOKEN_NAME, refreshToken)
        }
    }

    companion object {

        const val TOKEN_SHARED_PREFERENCES_NAME = "tokenSharedPreferences"
        const val ACCESS_TOKEN_NAME = "accessTokenName"
        const val REFRESH_TOKEN_NAME = "refreshTokenName"
    }
}