package ru.kpfu.itis.bagaviev.player.api.domain.interactor

import kotlinx.coroutines.flow.StateFlow
import ru.kpfu.itis.bagaviev.player.api.domain.entities.MusicItem

interface MusicControllerInteractor {

    val currentMusicItem: StateFlow<MusicItem?>

    val currentPlayingPositionInMs: StateFlow<Long?>

    val currentPlayingItemDuration: StateFlow<Long?>

    val isPlaying: StateFlow<Boolean?>

    fun play()

    fun play(musicItem: MusicItem)

    fun pause()

    fun playNext()

    fun playPrevious()

    fun seekTo(positionInMs: Long)

    fun add(musicItem: MusicItem)

    fun add(musicItemList: List<MusicItem>)

    fun clearQueue()
}