package ru.kpfu.itis.bagaviev.data.music.impl.data.network.core

import ru.kpfu.itis.bagaviev.data.music.impl.BuildConfig

object ApiConfig {

    const val BASE_URL = BuildConfig.BASE_URL
    const val HEADER_AUTHORIZATION = "Authorization"
    const val CONNECTION_TIMEOUT_MS = 1000 * 60L
}