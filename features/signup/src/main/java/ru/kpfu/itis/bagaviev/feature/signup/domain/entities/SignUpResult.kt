package ru.kpfu.itis.bagaviev.feature.signup.domain.entities

data class SignUpResult(
    val accessToken: String,
    val refreshToken: String
)