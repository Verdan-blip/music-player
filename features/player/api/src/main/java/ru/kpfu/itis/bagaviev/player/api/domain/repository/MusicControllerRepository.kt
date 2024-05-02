package ru.kpfu.itis.bagaviev.player.api.domain.repository

import kotlinx.coroutines.flow.StateFlow
import ru.kpfu.itis.bagaviev.player.api.domain.entities.MusicItem

interface MusicControllerRepository {

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