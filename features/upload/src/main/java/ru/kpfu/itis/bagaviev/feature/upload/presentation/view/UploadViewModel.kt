package ru.kpfu.itis.bagaviev.feature.upload.presentation.view

import android.util.Log
import androidx.core.net.toFile
import androidx.core.net.toUri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.kpfu.itis.bagaviev.common.base.BaseViewModel
import ru.kpfu.itis.bagaviev.common.util.extensions.progressAsTime
import ru.kpfu.itis.bagaviev.common.util.extensions.timeAsMmSs
import ru.kpfu.itis.bagaviev.common.util.typealiases.ViewModelFactories
import ru.kpfu.itis.bagaviev.feature.upload.domain.entity.TrackUploadForm
import ru.kpfu.itis.bagaviev.feature.upload.domain.usecase.SearchUsersByKeywordsUseCase
import ru.kpfu.itis.bagaviev.feature.upload.domain.usecase.UploadTrackUseCase
import ru.kpfu.itis.bagaviev.feature.upload.presentation.entity.UserModel
import ru.kpfu.itis.bagaviev.feature.upload.presentation.event.PickMediaEvent
import ru.kpfu.itis.bagaviev.feature.upload.presentation.mapper.toUser
import ru.kpfu.itis.bagaviev.feature.upload.presentation.mapper.toUserModel
import ru.kpfu.itis.bagaviev.feature.upload.presentation.state.UiState
import ru.kpfu.itis.bagaviev.feature.upload.presentation.state.UploadState
import ru.kpfu.itis.bagaviev.feature.upload.presentation.util.file_manager.VideoMetadataManager
import javax.inject.Inject

class UploadViewModel @Inject constructor(
    private val videoMetadataManager: VideoMetadataManager,
    private val uploadTrackUseCase: UploadTrackUseCase,
    private val searchUsersByKeywordsUseCase: SearchUsersByKeywordsUseCase
) : BaseViewModel() {

    private val _pickMediaEvent = MutableSharedFlow<PickMediaEvent>()

    val pickMediaEvent: SharedFlow<PickMediaEvent>
        get() = _pickMediaEvent

    private val _uiState = MutableStateFlow(UiState())

    val uiState: StateFlow<UiState>
        get() = _uiState

    private val _foundAuthorsState = MutableStateFlow<List<UserModel>>(listOf())

    val foundAuthorsState: StateFlow<List<UserModel>>
        get() = _foundAuthorsState

    private val _showSearchUsersDialogEvent = MutableSharedFlow<Boolean>()

    val showSearchUsersDialogEvent: SharedFlow<Boolean>
        get() = _showSearchUsersDialogEvent

    private val _uploadState = MutableStateFlow(UploadState())

    private val _clipDurationState = MutableStateFlow<Long?>(null)


    fun onAuthorLongClick(authorId: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            val pickedAuthors = _uiState.value.authors.toMutableList()
            pickedAuthors.removeAll { userModel -> userModel.id == authorId }
            _uiState.emit(_uiState.value.copy(authors = pickedAuthors))
        }
    }

    fun onAuthorPlaceholderClick() {
        viewModelScope.launch(Dispatchers.IO) {
            _showSearchUsersDialogEvent.emit(true)
        }
    }

    fun onUploadClick() {
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
            _uploadState.emit(
                _uploadState.value.copy(smallCoverUri = uri?.toUri())
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
            _uploadState.emit(
                _uploadState.value.copy(coverUri = uri?.toUri())
            )
            _uiState.emit(
                _uiState.value.copy(
                    coverUri = uri
                )
            )
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
                _uploadState.emit(
                    _uploadState.value.copy(audioUri = audioFileUri.toUri())
                )
                _uiState.emit(
                    _uiState.value.copy(
                        audioFileName = videoMetadataManager.extractFileName(audioFileUri)
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
                _uploadState.emit(
                    _uploadState.value.copy(videoUri = videoFileUri.toUri())
                )
                _uiState.emit(
                    _uiState.value.copy(
                        clipFileName = videoMetadataManager.extractFileName(uri),
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
                _uiState.emit(
                    _uiState.value.copy(
                        clipStartTime = min.progressAsTime(duration).timeAsMmSs(),
                        clipEndTime = max.progressAsTime(duration).timeAsMmSs()
                    )
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