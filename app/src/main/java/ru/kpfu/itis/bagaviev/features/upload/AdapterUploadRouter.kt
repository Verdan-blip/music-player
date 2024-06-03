package ru.kpfu.itis.bagaviev.features.upload

import ru.kpfu.itis.bagaviev.feature.upload.UploadRouter
import ru.kpfu.itis.bagaviev.presentation.GlobalRouter
import javax.inject.Inject

class AdapterUploadRouter @Inject constructor(
    private val globalRouter: GlobalRouter
) : UploadRouter {

    override fun navigateToProfile() {
        globalRouter.navigateToProfile()
    }
}