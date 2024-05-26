package ru.kpfu.itis.bagaviev.player.impl.data.impl

import android.util.Log
import androidx.media3.common.Player
import androidx.media3.session.MediaController
import com.google.common.util.concurrent.ListenableFuture
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.guava.await
import kotlinx.coroutines.launch
import ru.kpfu.itis.bagaviev.player.api.domain.entities.MusicItem
import ru.kpfu.itis.bagaviev.player.api.domain.entities.PlayerCallback
import ru.kpfu.itis.bagaviev.player.api.domain.entities.PlayerState
import ru.kpfu.itis.bagaviev.player.api.domain.repository.MusicPlayerRepository
import ru.kpfu.itis.bagaviev.player.impl.data.mappers.toMediaItem
import ru.kpfu.itis.bagaviev.player.impl.data.mappers.toMusicItem
import ru.kpfu.itis.bagaviev.player.impl.presentation.util.currentMediaItemAsFlow
import ru.kpfu.itis.bagaviev.player.impl.presentation.util.currentPlayingItemDurationAsFlow
import ru.kpfu.itis.bagaviev.player.impl.presentation.util.currentPlayingPositionAsFlow
import ru.kpfu.itis.bagaviev.player.impl.presentation.util.isPlayingAsFlow
import javax.inject.Inject

@OptIn(DelicateCoroutinesApi::class)
class MusicPlayerRepositoryImpl @Inject constructor(
    private val mediaControllerFuture: ListenableFuture<MediaController>
) : MusicPlayerRepository {

    private var player: Player? = null

    private val _playerState = MutableStateFlow(PlayerState())

    override val playerState: StateFlow<PlayerState>
        get() = _playerState


    private val _playerCallback = MutableStateFlow<PlayerCallback>(PlayerCallback.PlayerInitializing)

    override val playerCallback: StateFlow<PlayerCallback>
        get() = _playerCallback


    init {
        GlobalScope.launch(Dispatchers.Main) {
            initPlayer()
            launch { collectIsPlayingFlow() }
            launch { collectCurrentMediaItemFlow() }
            launch { collectCurrentPlayingPositionFlow() }
            launch { collectCurrentPlayingItemDurationFlow() }
        }
    }

    private suspend fun collectIsPlayingFlow() {
        player?.apply {
            isPlayingAsFlow()
                .filterNotNull()
                .collect { isPlaying ->
                    _playerCallback.emit(PlayerCallback.IsPlayingChanged(isPlaying))
                    _playerState.emit(_playerState.value.copy(isPlaying = isPlaying))
                }
        }
    }

    private suspend fun collectCurrentMediaItemFlow() {
        player?.apply {
            currentMediaItemAsFlow()
                .filterNotNull()
                .collect { mediaItem ->
                    val musicItem = mediaItem.toMusicItem()
                    _playerCallback.emit(PlayerCallback.MusicItemChanged(musicItem))
                    _playerState.emit(_playerState.value.copy(currentMusicItem = musicItem))
                }
        }
    }

    private suspend fun collectCurrentPlayingItemDurationFlow() {
        player?.apply {
            currentPlayingItemDurationAsFlow()
                .filterNotNull()
                .collect { duration ->
                    Log.d("in_repos", duration.toString())
                    _playerCallback.emit(PlayerCallback.ItemDurationChanged(duration))
                    _playerState.emit(_playerState.value.copy(currentPlayingItemDuration = duration))
                }
        }
    }

    private suspend fun collectCurrentPlayingPositionFlow() {
        player?.apply {
            currentPlayingPositionAsFlow()
                .filterNotNull()
                .collect { positionInMs ->
                    _playerCallback.emit(PlayerCallback.PlayingPositionChanged(positionInMs))
                    _playerState.emit(_playerState.value.copy(currentPlayingProgress = positionInMs))
                }
        }
    }

    private suspend fun initPlayer() {
        player = mediaControllerFuture.await()
        player?.prepare()
    }

    override fun play() {
        player?.play()
    }

    override fun play(musicItem: MusicItem) {
        player?.setMediaItem(musicItem.toMediaItem())
        player?.play()
    }

    override fun pause() {
        player?.pause()
    }

    override fun playNext() {
        player?.seekToNext()
    }

    override fun playPrevious() {
        player?.seekToPrevious()
    }

    override fun seekTo(positionInMs: Long) {
        player?.seekTo(positionInMs)
    }

    override fun add(musicItem: MusicItem) {
        player?.addMediaItem(musicItem.toMediaItem())
    }

    override fun add(musicItemList: List<MusicItem>) {
        player?.addMediaItems(musicItemList.map {
            musicItem -> musicItem.toMediaItem()
        })
    }

    override fun clearQueue() {
        player?.clearMediaItems()
    }
}