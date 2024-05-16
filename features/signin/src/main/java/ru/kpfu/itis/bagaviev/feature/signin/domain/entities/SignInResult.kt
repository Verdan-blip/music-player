package ru.kpfu.itis.bagaviev.feature.signin.domain.entities

data class SignInResult(
    val accessToken: String,
    val refreshToken: String
)