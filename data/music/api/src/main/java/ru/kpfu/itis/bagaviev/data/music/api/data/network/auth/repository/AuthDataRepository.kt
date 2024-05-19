package ru.kpfu.itis.bagaviev.data.music.api.data.network.auth.repository

import ru.kpfu.itis.bagaviev.data.music.api.data.network.auth.entity.LoginDataEntity
import ru.kpfu.itis.bagaviev.data.music.api.data.network.auth.entity.RegisterDataEntity
import ru.kpfu.itis.bagaviev.data.music.api.data.network.auth.entity.TokenDataEntity

interface AuthDataRepository {

    suspend fun signIn(loginDataEntity: LoginDataEntity): TokenDataEntity

    suspend fun signUp(registerDataEntity: RegisterDataEntity): TokenDataEntity

    suspend fun getAccessToken(refreshToken: String): TokenDataEntity

    suspend fun refresh(refreshToken: String): TokenDataEntity
}