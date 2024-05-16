package ru.kpfu.itis.bagaviev.feature.signin.presentation.view

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.kpfu.itis.bagaviev.common.base.BaseViewModel
import ru.kpfu.itis.bagaviev.common.util.typealiases.ViewModelFactories
import ru.kpfu.itis.bagaviev.feature.signin.SignInRouter
import ru.kpfu.itis.bagaviev.feature.signin.domain.repository.SignInTokenRepository
import ru.kpfu.itis.bagaviev.feature.signin.domain.usecase.SaveTokensUseCase
import ru.kpfu.itis.bagaviev.feature.signin.domain.usecase.SignInUseCase
import ru.kpfu.itis.bagaviev.feature.signin.presentation.entity.SignInFormModel
import ru.kpfu.itis.bagaviev.feature.signin.presentation.entity.mapper.toSignInForm
import javax.inject.Inject

class SignInViewModel @Inject constructor(
    private val signInUseCase: SignInUseCase,
    private val saveTokensUseCase: SaveTokensUseCase,
    private val signInRouter: SignInRouter
) : BaseViewModel() {

    fun onSignUpPress() {
        signInRouter.navigateToSignUp()
    }

    fun onSignInPress(signInFormModel: SignInFormModel) {
        viewModelScope.launch {
            signInUseCase(signInFormModel.toSignInForm()).fold(
                onSuccess = { signInResult ->
                    signInRouter.navigateToProfile()
                    saveTokensUseCase(
                        accessToken = signInResult.accessToken,
                        refreshToken = signInResult.refreshToken
                    )
                },
                onFailure = { throwable ->
                    showAlert(throwable.message.toString())
                }
            )
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