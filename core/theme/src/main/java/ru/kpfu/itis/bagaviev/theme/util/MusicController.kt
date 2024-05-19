package ru.kpfu.itis.bagaviev.theme.util

import kotlinx.coroutines.flow.StateFlow

interface MusicController {

    val musicControllerState: StateFlow<MusicControllerState>

    fun play()

    fun pause()

    fun seekTo(positionInMs: Long)
}