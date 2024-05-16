package ru.kpfu.itis.bagaviev.data.auth.api.data.repositories

import ru.kpfu.itis.bagaviev.data.auth.api.data.entities.requests.LoginRequestDataEntity
import ru.kpfu.itis.bagaviev.data.auth.api.data.entities.requests.RegisterRequestDataEntity

interface AuthRepository {

    suspend fun register(registerRequestDataEntity: RegisterRequestDataEntity)

    suspend fun login(loginRequestDataEntity: LoginRequestDataEntity)
}