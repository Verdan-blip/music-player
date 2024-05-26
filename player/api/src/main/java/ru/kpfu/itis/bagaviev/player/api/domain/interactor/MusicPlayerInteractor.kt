package ru.kpfu.itis.bagaviev.player.api.domain.interactor

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import ru.kpfu.itis.bagaviev.player.api.domain.entities.MusicItem
import ru.kpfu.itis.bagaviev.player.api.domain.entities.PlayerCallback
import ru.kpfu.itis.bagaviev.player.api.domain.entities.PlayerState

interface MusicPlayerInteractor {

    val playerCallback: Flow<PlayerCallback>

    val playerState: StateFlow<PlayerState>

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