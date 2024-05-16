package ru.kpfu.itis.bagaviev.features.signin

import ru.kpfu.itis.bagaviev.feature.signin.SignInRouter
import ru.kpfu.itis.bagaviev.presentation.GlobalRouter
import javax.inject.Inject

class AdapterSignInRouter @Inject constructor(
    private val globalRouter: GlobalRouter
) : SignInRouter {

    override fun navigateToProfile() {
        globalRouter.navigateToProfile()
    }

    override fun navigateToSignUp() {
        globalRouter.navigateToSignUp()
    }
}