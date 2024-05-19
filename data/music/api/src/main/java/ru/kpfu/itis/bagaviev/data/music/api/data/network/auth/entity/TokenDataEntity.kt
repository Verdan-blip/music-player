package ru.kpfu.itis.bagaviev.data.music.api.data.network.auth.entity

class TokenDataEntity(
    val accessToken: String,
    val refreshToken: String,
    val expiresIn: Int
)