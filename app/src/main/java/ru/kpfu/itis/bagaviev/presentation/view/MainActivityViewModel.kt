package ru.kpfu.itis.bagaviev.presentation.view

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.kpfu.itis.bagaviev.common.base.music.BaseMusicViewModel
import ru.kpfu.itis.bagaviev.common.util.extensions.progressAsTime
import ru.kpfu.itis.bagaviev.data.music.api.data.local.music.repository.DownloadedTrackDataRepository
import ru.kpfu.itis.bagaviev.player.api.domain.entities.MusicItem
import ru.kpfu.itis.bagaviev.player.api.domain.entities.PlayerCallback
import ru.kpfu.itis.bagaviev.player.api.domain.interactor.MusicPlayerInteractor
import ru.kpfu.itis.bagaviev.player.api.domain.repository.MusicDownloadRepository
import ru.kpfu.itis.bagaviev.presentation.entity.DownloadedTrackModel
import ru.kpfu.itis.bagaviev.presentation.entity.mapper.toDownloadedTrackDataEntity
import ru.kpfu.itis.bagaviev.presentation.state.UiState
import ru.kpfu.itis.bagaviev.presentation.util.toClipData
import ru.kpfu.itis.bagaviev.presentation.util.toMusicData
import ru.kpfu.itis.bagaviev.presentation.util.toMusicItem
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(
    private val interactor: MusicPlayerInteractor,
    private val musicDownloadRepository: MusicDownloadRepository,
    private val downloadedTrackDataRepository: DownloadedTrackDataRepository,
) : BaseMusicViewModel() {

    override val coroutineDispatcher: CoroutineDispatcher = Dispatchers.IO


    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState>
        get() = _uiState


    private val _musicItem = MutableStateFlow<MusicItem?>(null)
    val musicItem: StateFlow<MusicItem?>
        get() = _musicItem

    private var shouldTrackProgress: Boolean = true

    private val pendingMusicsToDownload: MutableMap<Long, MusicData> = mutableMapOf()

    init {
        viewModelScope.launch {
            collectPlayerCallbacks()
        }
    }

    private suspend fun collectPlayerCallbacks() {
        interactor.playerCallback.collect { callback ->
            when (callback) {
                is PlayerCallback.PlayerInitializing -> Unit
                is PlayerCallback.ItemDurationChanged -> {
                    emitDuration(callback.duration)
                }
                is PlayerCallback.MusicItemChanged -> {
                    callback.musicItem.apply {
                        emitMusicData(toMusicData())
                        _uiState.emit(_uiState.value.copy(
                            clipData = clipData?.toClipData(),
                            backgroundUri = coverUri
                        ))
                    }
                }
                is PlayerCallback.PlayingPositionChanged -> {
                    if (shouldTrackProgress) {
                        emitPlayingTime(callback.positionInMs)
                    }
                }
                is PlayerCallback.IsPlayingChanged -> {
                    emitIsPlaying(callback.isPlaying)
                }
            }
        }
    }

    override fun onPlayPause() {
        if (interactor.playerState.value.isPlaying == true)
            interactor.pause()
        else
            interactor.play()
    }

    override fun onPlay(musicData: MusicData) {
        interactor.play(musicData.toMusicItem())
    }

    override fun onSeekTo(progress: Int) {
        shouldTrackProgress = true
        interactor.seekTo(progress.progressAsTime(durationState.value))
    }

    override fun onSeeking(progress: Int) {
        shouldTrackProgress = false
        emitPlayingTime(progress.progressAsTime(durationState.value))
    }

    override fun onPlayNext() {
        interactor.playNext()
    }

    override fun onPlayPrevious() {
        interactor.playPrevious()
    }

    override fun onDownload(musicData: MusicData) {
        viewModelScope.launch {
            with (musicData) {
                val downloadId = musicDownloadRepository.startDownloading(toMusicItem())
                downloadId?.also { id ->
                    pendingMusicsToDownload[id] = musicData
                }
            }
        }
    }

    override fun onDownloadComplete(downloadId: Long, newUri: String) {
        viewModelScope.launch {
            val musicItem = pendingMusicsToDownload.remove(downloadId)
            musicItem?.apply {
                downloadedTrackDataRepository.insert(
                    DownloadedTrackModel(
                        id = id,
                        title = title,
                        users = authors,
                        smallCoverUri = coverUri,
                        audiUri = newUri
                    ).toDownloadedTrackDataEntity()
                )
            }
        }
    }
}