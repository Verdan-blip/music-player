package ru.kpfu.itis.bagaviev.theme.viewmodel

import ru.kpfu.itis.bagaviev.common.base.BaseViewModel
import ru.kpfu.itis.bagaviev.theme.util.MusicController

abstract class MusicViewModel : BaseViewModel() {

    abstract val musicController: MusicController

    fun onPlayPause() {
        val isPlaying = musicController.musicControllerState.value.isPlayingNow
        if (isPlaying)
            musicController.play()
        else
            musicController.pause()
    }

    fun onSeekTo(positionInMs: Long) {
        musicController.seekTo(positionInMs)
    }
}