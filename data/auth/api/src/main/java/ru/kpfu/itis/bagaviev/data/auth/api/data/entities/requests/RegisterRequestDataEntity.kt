package ru.kpfu.itis.bagaviev.data.auth.api.data.entities.requests

import java.util.Date

data class RegisterRequestDataEntity(
    val login: String,
    val email: String,
    val gender: String,
    val birthDate: Date,
    val password: String,
    val confirmPassword: String
)