package ru.kpfu.itis.bagaviev.feature.signup.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.kpfu.itis.bagaviev.common.base.BaseViewModel
import ru.kpfu.itis.bagaviev.common.util.typealiases.ViewModelFactories
import ru.kpfu.itis.bagaviev.feature.signup.SignUpRouter
import ru.kpfu.itis.bagaviev.feature.signup.domain.usecases.SignUpUseCase
import ru.kpfu.itis.bagaviev.feature.signup.presentation.entities.SignUpFormModel
import ru.kpfu.itis.bagaviev.feature.signup.presentation.entities.mappers.toSignUpForm
import javax.inject.Inject

class SignUpViewModel @Inject constructor(
    private val signUpUseCase: SignUpUseCase,
    private val signUpRouter: SignUpRouter
) : BaseViewModel() {

    fun onSignUpPress(signUpFormModel: SignUpFormModel) {
        viewModelScope.launch {
            val authResult = signUpUseCase(signUpFormModel.toSignUpForm())
            authResult.fold(
                onSuccess = {
                    signUpRouter.navigateToProfile()
                },
                onFailure = { throwable ->
                    showAlert(throwable.message.toString())
                }
            )
        }
    }

    fun onSignInPress() {
        signUpRouter.navigateToSignIn()
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