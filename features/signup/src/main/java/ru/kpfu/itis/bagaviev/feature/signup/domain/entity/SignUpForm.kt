package ru.kpfu.itis.bagaviev.feature.signup.domain.entity

data class SignUpForm(
    val email: String,
    val login: String,
    val password: String,
    val confirmedPassword: String
)