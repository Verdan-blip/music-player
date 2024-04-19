package ru.kpfu.itis.bagaviev.api.domain.interactor

import ru.kpfu.itis.bagaviev.api.domain.repository.MusicControllerRepository

class MusicControllerInteractor(
    private val musicControllerRepository: MusicControllerRepository
) {

    var currentMusicItem = musicControllerRepository.currentMusicItem

    var isPlaying = musicControllerRepository.isPlaying

    var currentPlayingPositionInMs = musicControllerRepository.currentPlayingPositionInMs

    fun play() {
        musicControllerRepository.play()
    }

    fun pause() {
        musicControllerRepository.pause()
    }

    fun playNext() {
        musicControllerRepository.playNext()
    }

    fun playPrevious() {
        musicControllerRepository.playPrevious()
    }

    fun seekTo(positionInMs: Long) {
        musicControllerRepository.seekTo(positionInMs)
    }
}