package ru.kpfu.itis.bagaviev.feature.signup.domain.entities

data class SignUpForm(
    val email: String,
    val login: String,
    val password: String,
    val confirmedPassword: String
)