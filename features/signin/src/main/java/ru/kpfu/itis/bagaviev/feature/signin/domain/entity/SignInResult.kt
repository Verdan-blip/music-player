package ru.kpfu.itis.bagaviev.feature.signin.domain.entity

data class SignInResult(
    val accessToken: String,
    val refreshToken: String
)