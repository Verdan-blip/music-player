package ru.kpfu.itis.bagaviev.features.profile

import ru.kpfu.itis.bagaviev.feature.profile.ProfileRouter
import ru.kpfu.itis.bagaviev.presentation.GlobalRouter
import javax.inject.Inject

class AdapterProfileRouter @Inject constructor(
    private val globalRouter: GlobalRouter
) : ProfileRouter {

    override fun navigateToSignIn() {
        globalRouter.navigateToSignIn()
    }
}