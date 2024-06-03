package ru.kpfu.itis.bagaviev.feature.upload.presentation.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import okio.Path.Companion.toPath
import ru.kpfu.itis.bagaviev.common.base.BaseViewModel
import ru.kpfu.itis.bagaviev.common.core.ResourceManager
import ru.kpfu.itis.bagaviev.common.util.extensions.progressAsTime
import ru.kpfu.itis.bagaviev.common.util.extensions.timeAsMmSs
import ru.kpfu.itis.bagaviev.common.util.typealiases.ViewModelFactories
import ru.kpfu.itis.bagaviev.feature.upload.R
import ru.kpfu.itis.bagaviev.feature.upload.UploadRouter
import ru.kpfu.itis.bagaviev.feature.upload.domain.exceptions.TrackAudioFileNotDefinedException
import ru.kpfu.itis.bagaviev.feature.upload.domain.exceptions.TrackCoverFileNotDefinedException
import ru.kpfu.itis.bagaviev.feature.upload.domain.exceptions.TrackGenreNotDefinedException
import ru.kpfu.itis.bagaviev.feature.upload.domain.exceptions.TrackTitleNotDefinedException
import ru.kpfu.itis.bagaviev.feature.upload.domain.usecase.CheckIsAuthenticatedUseCase
import ru.kpfu.itis.bagaviev.feature.upload.domain.usecase.GetCurrentUserUseCase
import ru.kpfu.itis.bagaviev.feature.upload.domain.usecase.SearchUsersByKeywordsUseCase
import ru.kpfu.itis.bagaviev.feature.upload.domain.usecase.UploadTrackUseCase
import ru.kpfu.itis.bagaviev.feature.upload.presentation.entity.ClipDataModel
import ru.kpfu.itis.bagaviev.feature.upload.presentation.entity.TrackUploadFormModel
import ru.kpfu.itis.bagaviev.feature.upload.presentation.entity.UserFeedModel
import ru.kpfu.itis.bagaviev.feature.upload.presentation.event.PickMediaEvent
import ru.kpfu.itis.bagaviev.feature.upload.presentation.mapper.toNonValidatedTrackUploadForm
import ru.kpfu.itis.bagaviev.feature.upload.presentation.mapper.toUserModel
import ru.kpfu.itis.bagaviev.feature.upload.presentation.state.MediaUploadState
import ru.kpfu.itis.bagaviev.feature.upload.presentation.state.UiState
import ru.kpfu.itis.bagaviev.feature.upload.presentation.util.file_manager.VideoMetadataManager
import java.io.File
import javax.inject.Inject

class UploadViewModel @Inject constructor(
    private val videoMetadataManager: VideoMetadataManager,
    private val uploadTrackUseCase: UploadTrackUseCase,
    private val searchUsersByKeywordsUseCase: SearchUsersByKeywordsUseCase,
    private val isAuthenticatedUseCase: CheckIsAuthenticatedUseCase,
    private val getCurrentUserUseCase: GetCurrentUserUseCase,
    private val uploadRouter: UploadRouter,
    private val resourceManager: ResourceManager
) : BaseViewModel() {

    override val coroutineDispatcher: CoroutineDispatcher = Dispatchers.IO


    private val _pickMediaEvent = MutableSharedFlow<PickMediaEvent>()

    val pickMediaEvent: SharedFlow<PickMediaEvent>
        get() = _pickMediaEvent

    private val _uiState = MutableStateFlow(UiState())

    val uiState: StateFlow<UiState>
        get() = _uiState

    private val _foundAuthorsState = MutableStateFlow<List<UserFeedModel>>(listOf())

    val foundAuthorsState: StateFlow<List<UserFeedModel>>
        get() = _foundAuthorsState

    private val _showSearchUsersDialogEvent = MutableSharedFlow<Boolean>()

    val showSearchUsersDialogEvent: SharedFlow<Boolean>
        get() = _showSearchUsersDialogEvent

    private val _mediaUploadState = MutableStateFlow(MediaUploadState())

    private val _clipDurationState = MutableStateFlow<Long?>(null)

    private var currentUserId: Long? = null

    fun checkIsAuthenticated() {
        runBlocking {
            isAuthenticatedUseCase().fold(
                onSuccess = { isAuthenticated ->
                    if (isAuthenticated) {
                        getCurrentUserUseCase().fold(
                            onSuccess = { authorizedUser ->
                                currentUserId = authorizedUser.id
                                addCurrentUserToAuthors(authorizedUser.toUserModel())
                            },
                            onFailure = { throwable ->
                                showAlert(throwable.toString())
                                uploadRouter.navigateToProfile()
                            }
                        )
                    } else {
                        uploadRouter.navigateToProfile()
                    }
                },
                onFailure = { throwable ->
                    showAlert(throwable.toString())
                }
            )
        }
    }


    fun onAuthorLongClick(authorId: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            val pickedAuthors = _uiState.value.authors.toMutableList()
            pickedAuthors.removeAll { userModel ->
                userModel.id == authorId && userModel.id != currentUserId
            }
            _uiState.emit(_uiState.value.copy(authors = pickedAuthors))
        }
    }

    fun onAuthorPlaceholderClick() {
        viewModelScope.launch(Dispatchers.IO) {
            _showSearchUsersDialogEvent.emit(true)
        }
    }

    fun onTrackTitleConfirm(title: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _mediaUploadState.emit(_mediaUploadState.value.copy(title = title))
        }
    }

    fun onTrackGenreConfirm(genre: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _mediaUploadState.emit(_mediaUploadState.value.copy(genre = genre))
        }
    }

    fun onUploadClick() {
        viewModelScope.launch(Dispatchers.IO) {
            _uiState.value.apply {
                _mediaUploadState.value.apply {
                    uploadTrackUseCase(
                        TrackUploadFormModel(
                            title = title,
                            genre = genre,
                            authors = authors,
                            audioFile = audioFile,
                            coverFile = coverFile,
                            smallCoverFile = smallCoverFile,
                            clipData = ClipDataModel(
                                clipFile = videoFile,
                                startMs = clipStartMs,
                                endMs = clipEndMs
                            )
                        ).toNonValidatedTrackUploadForm()
                    ).fold(
                        onSuccess = {
                            showAlert(resourceManager.getString(
                                R.string.upload_fragment_submit_result_success)
                            )
                        },
                        onFailure = { throwable ->
                            handleUploadException(throwable)
                        }
                    )
                }
            }
        }
    }

    fun onFoundAuthorClick(authorId: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            _foundAuthorsState.value.firstOrNull { userModel ->
                authorId == userModel.id
            }?.also { foundAuthor ->
                val pickedAuthors = _uiState.value.authors.toMutableList()
                pickedAuthors.add(foundAuthor)
                _uiState.emit(_uiState.value.copy(authors = pickedAuthors))
            }
        }
    }

    fun onSearchKeywordsChange(query: String) {
        viewModelScope.launch(Dispatchers.IO) {
            searchUsersByKeywordsUseCase(query.split("\\+")).fold(
                onSuccess = { foundUsers ->
                    _foundAuthorsState.emit(foundUsers.map { user ->
                        user.toUserModel() }
                    )
                },
                onFailure = { throwable ->
                    showAlert(throwable.message.toString())
                }
            )
        }
    }

    fun onPickSmallCoverClick() {
        viewModelScope.launch(Dispatchers.IO) {
            _pickMediaEvent.emit(PickMediaEvent.SmallCover)
        }
    }

    fun onSmallCoverPicked(uri: String?) {
        viewModelScope.launch(Dispatchers.IO) {
            _mediaUploadState.emit(
                _mediaUploadState.value.copy(smallCoverFile = uri?.toPath()?.toFile())
            )
            _uiState.emit(
                _uiState.value.copy(
                    smallCoverUri = uri
                )
            )
        }
    }

    fun onPickCoverClick() {
        viewModelScope.launch(Dispatchers.IO) {
            _pickMediaEvent.emit(PickMediaEvent.Cover)
        }
    }

    fun onCoverPicked(uri: String?) {
        viewModelScope.launch(Dispatchers.IO) {
            uri?.also { uriToFile ->
                _mediaUploadState.emit(
                    _mediaUploadState.value.copy(coverFile = File(uriToFile))
                )
                _uiState.emit(_uiState.value.copy(coverUri = uri))
            }
        }
    }

    fun onPickAudioClick() {
        viewModelScope.launch(Dispatchers.IO) {
            _pickMediaEvent.emit(PickMediaEvent.Audio)
        }
    }

    fun onAudioPicked(uri: String?) {
        viewModelScope.launch(Dispatchers.IO) {
            uri?.also { audioFileUri ->
                _mediaUploadState.emit(
                    _mediaUploadState.value.copy(audioFile = File(audioFileUri))
                )
                _uiState.emit(
                    _uiState.value.copy(
                        audioFileName = uri.toPath().name
                    )
                )
            }
        }
    }

    fun onPickVideoClipClick() {
        viewModelScope.launch(Dispatchers.IO) {
            _pickMediaEvent.emit(PickMediaEvent.VideoClip)
        }
    }

    fun onVideoClipPicked(uri: String?) {
        viewModelScope.launch(Dispatchers.IO) {
            uri?.also { videoFileUri ->
                _mediaUploadState.emit(
                    _mediaUploadState.value.copy(videoFile = File(videoFileUri))
                )
                _uiState.emit(
                    _uiState.value.copy(
                        clipFileName = uri.toPath().name,
                        isClipCorrectionActive = true,
                        clipStartTime = null,
                        clipEndTime = null
                    )
                )
                _clipDurationState.emit(
                    videoMetadataManager.extractDuration(uri)
                )
            }
        }
    }

    fun onDoubleValueSeekbarValueChanged(min: Int, max: Int) {
        _clipDurationState.value?.also { duration ->
            viewModelScope.launch(Dispatchers.IO) {
                val startTimeMs = min.progressAsTime(duration)
                val endTimeMs = max.progressAsTime(duration)
                _uiState.emit(
                    _uiState.value.copy(
                        clipStartTime = startTimeMs.timeAsMmSs(),
                        clipEndTime = endTimeMs.timeAsMmSs()
                    )
                )
                _mediaUploadState.emit(
                    _mediaUploadState.value.copy(
                        clipStartMs = startTimeMs,
                        clipEndMs = endTimeMs
                    )
                )
            }
        }
    }

    private fun addCurrentUserToAuthors(authorizedUser: UserFeedModel) {
        viewModelScope.launch(Dispatchers.IO) {
            _uiState.emit(
                _uiState.value.copy(authors = listOf(authorizedUser))
            )
        }
    }

    private fun handleUploadException(throwable: Throwable) {
        val message: String = when (throwable) {
            is TrackTitleNotDefinedException ->
                resourceManager.getString(R.string.upload_fragment_missing_track_title)
            is TrackGenreNotDefinedException ->
                resourceManager.getString(R.string.upload_fragment_missing_track_genre)
            is TrackAudioFileNotDefinedException ->
                resourceManager.getString(R.string.upload_fragment_missing_track_audio_file)
            is TrackCoverFileNotDefinedException ->
                resourceManager.getString(R.string.upload_fragment_missing_track_cover)
            else ->
                resourceManager.getString(
                    R.string.upload_fragment_submit_result_failure,
                    throwable.toString()
                )
        }
        showAlert(message)
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