package ru.kpfu.itis.bagaviev.glue.oauth

import ru.kpfu.itis.oauth.OAuthRouter
import javax.inject.Inject

class AdapterOAuthRouter @Inject constructor() : OAuthRouter {

    override fun openMainScreen() = Unit
}