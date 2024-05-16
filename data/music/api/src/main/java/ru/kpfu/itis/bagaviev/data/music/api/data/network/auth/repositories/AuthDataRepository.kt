package ru.kpfu.itis.bagaviev.data.music.api.data.network.auth.repositories

import ru.kpfu.itis.bagaviev.data.music.api.data.network.auth.entities.LoginDataEntity
import ru.kpfu.itis.bagaviev.data.music.api.data.network.auth.entities.RegisterDataEntity
import ru.kpfu.itis.bagaviev.data.music.api.data.network.auth.entities.TokenDataEntity

interface AuthDataRepository {

    suspend fun signIn(loginDataEntity: LoginDataEntity): TokenDataEntity

    suspend fun signUp(registerDataEntity: RegisterDataEntity): TokenDataEntity

    suspend fun refreshAccessToken(refreshToken: String): TokenDataEntity
}