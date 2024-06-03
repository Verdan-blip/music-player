package ru.kpfu.itis.bagaviev.feature.profile.presentation.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import ru.kpfu.itis.bagaviev.common.base.BaseViewModel
import ru.kpfu.itis.bagaviev.common.util.typealiases.ViewModelFactories
import ru.kpfu.itis.bagaviev.feature.profile.ProfileRouter
import ru.kpfu.itis.bagaviev.feature.profile.domain.usecase.CheckAuthenticationUseCase
import ru.kpfu.itis.bagaviev.feature.profile.domain.usecase.GetAllDownloadedTracksUseCase
import ru.kpfu.itis.bagaviev.feature.profile.domain.usecase.GetCurrentUserUseCase
import ru.kpfu.itis.bagaviev.feature.profile.presentation.entity.track.DownloadedTrackModel
import ru.kpfu.itis.bagaviev.feature.profile.presentation.entity.track.mapper.toDownloadedTrackModel
import ru.kpfu.itis.bagaviev.feature.profile.presentation.entity.user.UserProfileModel
import ru.kpfu.itis.bagaviev.feature.profile.presentation.entity.user.mapper.toUserDetailsModel
import javax.inject.Inject

class ProfileViewModel @Inject constructor(
    private val checkAuthenticationUseCase: CheckAuthenticationUseCase,
    private val getCurrentUserUseCase: GetCurrentUserUseCase,
    private val getAllDownloadedTracksUseCase: GetAllDownloadedTracksUseCase,
    private val profileRouter: ProfileRouter
) : BaseViewModel() {

    override val coroutineDispatcher: CoroutineDispatcher = Dispatchers.IO


    private val _userProfileState = MutableStateFlow<UserProfileModel?>(null)
    val userProfileState: StateFlow<UserProfileModel?>
        get() = _userProfileState

    private val _savedTracksState = MutableStateFlow<List<DownloadedTrackModel>>(listOf())
    val savedTracksState: StateFlow<List<DownloadedTrackModel>>
        get() = _savedTracksState


    fun checkAuthentication() {
        runBlocking {
            checkAuthenticationUseCase().fold(
                onSuccess = { isAuthenticated ->
                    if (isAuthenticated) {
                        viewModelScope.launch(Dispatchers.IO) {
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
                        viewModelScope.launch(Dispatchers.IO) {
                            getAllDownloadedTracksUseCase().fold(
                                onSuccess = { downloadedTrackList ->
                                    _savedTracksState.emit(downloadedTrackList.map {
                                        downloadedTrack -> downloadedTrack.toDownloadedTrackModel()
                                    })
                                },
                                onFailure = { throwable ->
                                    showAlert(throwable.message.toString())
                                }
                            )
                        }
                    } else {
                        profileRouter.navigateToSignIn()
                    }
                },
                onFailure = { throwable ->
                    showAlert(throwable.toString())
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