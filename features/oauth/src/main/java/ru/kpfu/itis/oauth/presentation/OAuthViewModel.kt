package ru.kpfu.itis.oauth.presentation

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.kpfu.itis.bagaviev.common.states.CustomTabsState
import ru.kpfu.itis.bagaviev.common.util.typealiases.ViewModelFactories
import ru.kpfu.itis.oauth.OAuthRouter
import ru.kpfu.itis.oauth.domain.usecase.GetOAuthUriUseCase
import ru.kpfu.itis.oauth.domain.usecase.GrantAccessTokenUseCase
import ru.kpfu.itis.oauth.domain.usecase.SaveAccessTokenUseCase
import javax.inject.Inject

class OAuthViewModel @Inject constructor(
    private val getOAuthUriUseCase: GetOAuthUriUseCase,
    private val grantAccessTokenUseCase: GrantAccessTokenUseCase,
    private val saveAccessTokenUseCase: SaveAccessTokenUseCase,
    private val router: OAuthRouter
) : ViewModel() {

    private val _customTabsState = MutableStateFlow<CustomTabsState>(CustomTabsState.NoAction)
    val customTabsState: StateFlow<CustomTabsState>
        get() = _customTabsState


    fun onAuthenticateButtonPressed() {
        viewModelScope.launch {
            val authUri = getOAuthUriUseCase()
            _customTabsState.emit(
                CustomTabsState.Opened(
                Uri.parse(authUri.toString()))
            )
        }
    }

    fun onAuthenticationCanceled() {
        viewModelScope.launch {
            _customTabsState.emit(CustomTabsState.Closed)
        }
    }

    private fun onAuthenticationSucceed(code: String) {
        viewModelScope.launch {
            val grantTokenData = grantAccessTokenUseCase(code)

            saveAccessTokenUseCase(grantTokenData.accessToken)

            _customTabsState.emit(CustomTabsState.Closed)
            router.openMainScreen()
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