package ru.kpfu.itis.bagaviev.feature.signup.domain.entity

data class SignUpResult(
    val accessToken: String,
    val refreshToken: String
)