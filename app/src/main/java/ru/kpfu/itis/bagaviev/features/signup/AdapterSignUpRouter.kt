package ru.kpfu.itis.bagaviev.features.signup

import ru.kpfu.itis.bagaviev.feature.signup.SignUpRouter
import ru.kpfu.itis.bagaviev.presentation.GlobalRouter
import javax.inject.Inject

class AdapterSignUpRouter @Inject constructor(
    private val globalRouter: GlobalRouter
) : SignUpRouter {

    override fun navigateToProfile() {
        globalRouter.navigateToProfile()
    }

    override fun navigateToSignIn() {
        globalRouter.navigateToSignIn()
    }
}