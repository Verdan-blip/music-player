package ru.kpfu.itis.auth.oauth.config

import ru.kpfu.itis.auth.BuildConfig

object OAuthApiConfig {

    const val CLIENT_ID = BuildConfig.JAMENDO_API_CLIENT_ID
    const val CLIENT_SECRET = BuildConfig.JAMENDO_API_CLIENT_SECRET

    const val SCHEME = "https"
    const val AUTHORITY = "api.jamendo.com"
    const val PATH = "v3.0/oauth/authorize"

    const val AUTH_URL = "https://api.jamendo.com/v3.0/oauth/authorize"

    const val SCOPE = "music"
    const val RESPONSE_TYPE = "code"
    const val GRAND_TYPE = "authorization_code"
}