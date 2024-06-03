package ru.kpfu.itis.bagaviev.common.base.music

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.kpfu.itis.bagaviev.common.base.BaseViewModel
import ru.kpfu.itis.bagaviev.common.util.extensions.timeAsMmSs
import ru.kpfu.itis.bagaviev.common.util.extensions.timeAsProgress

abstract class BaseMusicViewModel : BaseViewModel() {

    private val _isPlayingState = MutableStateFlow(false)
    val isPlayingState: StateFlow<Boolean>
        get() = _isPlayingState


    private val _playingProgressState =  MutableStateFlow(0)
    val playingProgressState: StateFlow<Int>
        get() = _playingProgressState


    private val _formattedPlayingTimeState =  MutableStateFlow(0L.timeAsMmSs())
    val formattedPlayingTimeState: StateFlow<String>
        get() = _formattedPlayingTimeState


    private val _durationState = MutableStateFlow(0L)
    val durationState: StateFlow<Long>
        get() = _durationState


    private val _currentMusicData = MutableStateFlow<MusicData?>(null)
    val currentMusicData: StateFlow<MusicData?>
        get() = _currentMusicData

    abstract fun onPlay(musicData: MusicData)

    abstract fun onPlayPause()

    abstract fun onSeekTo(progress: Int)

    abstract fun onSeeking(progress: Int)

    abstract fun onPlayNext()

    abstract fun onPlayPrevious()

    abstract fun onDownload(musicData: MusicData)

    abstract fun onDownloadComplete(downloadId: Long, newUri: String)


    protected fun emitIsPlaying(isPlaying: Boolean) {
        viewModelScope.launch(coroutineDispatcher) {
            _isPlayingState.emit(isPlaying)
        }
    }

    protected fun emitPlayingTime(time: Long) {
        viewModelScope.launch(coroutineDispatcher) {
            _formattedPlayingTimeState.emit(time.timeAsMmSs())
            _playingProgressState.emit(time.timeAsProgress(_durationState.value))
        }
    }

    protected fun emitDuration(duration: Long) {
        viewModelScope.launch(coroutineDispatcher) {
            _durationState.emit(duration)
        }
    }

    protected fun emitMusicData(musicData: MusicData) {
        viewModelScope.launch(coroutineDispatcher) {
            _currentMusicData.emit(musicData)
        }
    }

    class MusicData(
        val id: Long,
        val title: String,
        val authors: List<String>,
        val coverUri: String,
        val audioUri: String,
        val clipData: ClipData? = null
    )

    class ClipData(
        val clipUri: String,
        val clipStart: Long,
        val clipEnd: Long
    )
}