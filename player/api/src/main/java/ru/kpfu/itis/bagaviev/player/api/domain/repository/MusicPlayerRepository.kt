package ru.kpfu.itis.bagaviev.player.api.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.kpfu.itis.bagaviev.player.api.domain.entities.MusicItem
import ru.kpfu.itis.bagaviev.player.api.domain.entities.PlayerCallback
import ru.kpfu.itis.bagaviev.player.api.domain.entities.PlayerState

interface MusicPlayerRepository {

    val playerCallback: Flow<PlayerCallback>

    val playerState: Flow<PlayerState>

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