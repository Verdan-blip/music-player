package ru.kpfu.itis.bagaviev.player.impl.data.repository

import androidx.media3.common.Player
import androidx.media3.session.MediaController
import com.google.common.util.concurrent.ListenableFuture
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.guava.await
import kotlinx.coroutines.launch
import ru.kpfu.itis.bagaviev.player.api.domain.entities.MusicItem
import ru.kpfu.itis.bagaviev.player.api.domain.repository.MusicControllerRepository
import ru.kpfu.itis.bagaviev.player.impl.data.mapper.toMediaItem
import ru.kpfu.itis.bagaviev.player.impl.data.mapper.toMusicItem
import ru.kpfu.itis.bagaviev.player.impl.data.util.extensions.currentMediaItemAsFlow
import ru.kpfu.itis.bagaviev.player.impl.data.util.extensions.currentPlayingItemDurationAsFlow
import ru.kpfu.itis.bagaviev.player.impl.data.util.extensions.currentPlayingPositionAsFlow
import ru.kpfu.itis.bagaviev.player.impl.data.util.extensions.isPlayingAsFlow
import javax.inject.Inject

@OptIn(DelicateCoroutinesApi::class)
class MusicControllerRepositoryImpl @Inject constructor(
    private val mediaControllerFuture: ListenableFuture<MediaController>
) : MusicControllerRepository {

    private var player: Player? = null

    override val currentMusicItem = MutableStateFlow<MusicItem?>(null)

    override val currentPlayingPositionInMs = MutableStateFlow<Long?>(null)

    override val currentPlayingItemDuration =  MutableStateFlow<Long?>(null)

    override val isPlaying = MutableStateFlow<Boolean?>(null)

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
        player?.isPlayingAsFlow()?.collect(isPlaying::emit)
    }

    private suspend fun collectCurrentMediaItemFlow() {
        player?.apply {
            currentMediaItemAsFlow()
                .filterNotNull()
                .collect { mediaItem ->
                    currentMusicItem.emit(mediaItem.toMusicItem())
                }
        }
    }

    private suspend fun collectCurrentPlayingItemDurationFlow() {
        player?.apply {
            currentPlayingItemDurationAsFlow()
                .filterNotNull()
                .collect(currentPlayingItemDuration::emit)
        }
    }

    private suspend fun collectCurrentPlayingPositionFlow() {
        player?.currentPlayingPositionAsFlow()?.collect(currentPlayingPositionInMs::emit)
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