package ru.kpfu.itis.bagaviev.data.music.api.data.network.auth.entities

import java.util.Date

class TokenDataEntity(
    val accessToken: String,
    val expiresIn: Date,
    val refreshToken: String
)