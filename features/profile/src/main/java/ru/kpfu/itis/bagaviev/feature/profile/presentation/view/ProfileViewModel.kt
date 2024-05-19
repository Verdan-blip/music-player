package ru.kpfu.itis.bagaviev.feature.profile.presentation.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import ru.kpfu.itis.bagaviev.common.base.BaseViewModel
import ru.kpfu.itis.bagaviev.common.util.typealiases.ViewModelFactories
import ru.kpfu.itis.bagaviev.feature.profile.ProfileRouter
import ru.kpfu.itis.bagaviev.feature.profile.domain.usecase.CheckAuthenticationUseCase
import ru.kpfu.itis.bagaviev.feature.profile.domain.usecase.GetCurrentUserUseCase
import ru.kpfu.itis.bagaviev.feature.profile.presentation.entity.user.UserProfileModel
import ru.kpfu.itis.bagaviev.feature.profile.presentation.entity.user.mapper.toUserDetailsModel
import javax.inject.Inject

class ProfileViewModel @Inject constructor(
    private val checkAuthenticationUseCase: CheckAuthenticationUseCase,
    private val getCurrentUserUseCase: GetCurrentUserUseCase,
    private val profileRouter: ProfileRouter
) : BaseViewModel() {

    private val _userProfileState = MutableStateFlow<UserProfileModel?>(null)

    val userProfileState: StateFlow<UserProfileModel?>
        get() = _userProfileState


    fun checkAuthentication() {
        runBlocking {
            if (!checkAuthenticationUseCase()) {
                profileRouter.navigateToSignIn()
            } else {
                getCurrentUserUseCase().fold(
                    onSuccess = { userProfile ->
                        val userProfileModel = userProfile.toUserDetailsModel()
                        _userProfileState.emit(userProfileModel)
                    },
                    onFailure = { throwable ->
                        showAlert(throwable.toString())
                    }
                )
            }
        }
    }


    companion object {

        class Factory @Inject constructor(
            private val viewModelFactories: ViewModelFactories
        ) : ViewModelProvider.Factory {

            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return viewModelFactories.getValue(modelClass).get() as T
            }
        }
    }
}