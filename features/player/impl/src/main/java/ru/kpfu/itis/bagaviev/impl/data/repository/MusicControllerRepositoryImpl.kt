package ru.kpfu.itis.bagaviev.impl.data.repository

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
import ru.kpfu.itis.bagaviev.api.domain.entities.MusicItem
import ru.kpfu.itis.bagaviev.api.domain.repository.MusicControllerRepository
import ru.kpfu.itis.bagaviev.impl.data.mapper.toMediaItem
import ru.kpfu.itis.bagaviev.impl.data.mapper.toMusicItem
import ru.kpfu.itis.bagaviev.impl.util.extensions.currentMediaItemAsFlow
import ru.kpfu.itis.bagaviev.impl.util.extensions.currentPlayingPositionAsFlow
import ru.kpfu.itis.bagaviev.impl.util.extensions.isPlayingAsFlow
import ru.kpfu.itis.common.util.extensions.toURI
import javax.inject.Inject

@OptIn(DelicateCoroutinesApi::class)
class MusicControllerRepositoryImpl @Inject constructor(
    private val mediaControllerFuture: ListenableFuture<MediaController>
) : MusicControllerRepository {

    private var player: Player? = null

    override val currentMusicItem = MutableStateFlow<MusicItem?>(null)

    override val currentPlayingPositionInMs = MutableStateFlow<Long?>(null)

    override val isPlaying = MutableStateFlow<Boolean?>(null)

    init {
        GlobalScope.launch(Dispatchers.Main) {
            initPlayer()
            launch { collectIsPlayingFlow() }
            launch { collectCurrentMediaItemFlow() }
            launch { collectCurrentPlayingPositionFlow() }
        }
    }

    private suspend fun collectIsPlayingFlow() {
        player?.isPlayingAsFlow()?.collect { playing ->
            isPlaying.emit(playing)
        }
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

    private suspend fun collectCurrentPlayingPositionFlow() {
        player?.currentPlayingPositionAsFlow()?.collect { currentPlayingPosition ->
            currentPlayingPositionInMs.emit(currentPlayingPosition)
        }
    }

    private suspend fun initPlayer() {
        player = mediaControllerFuture.await()
        player?.addMediaItem(
            MusicItem(
                id = 0,
                title = "За край", listOf("Три дня дождя"),
                duration = 201000L,
                posterUri = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRXXwAe4fzOc8kjKYF_XonJmvz92PQKexo2lSXP0jTH5g&s".toURI(),
                fileUri = "https://mp3uks.ru/mp3/files/tri-dnya-dozhdya-za-kraj-mp3.mp3".toURI()
            ).toMediaItem()
        )
        player?.prepare()
    }

    override fun play() {
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
        player?.addMediaItems(musicItemList.map { it.toMediaItem() })
    }
}