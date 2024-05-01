package ru.kpfu.itis.bagaviev.impl.domain.interactor

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ru.kpfu.itis.bagaviev.api.domain.entities.MusicItem
import ru.kpfu.itis.bagaviev.api.domain.interactor.MusicControllerInteractor
import ru.kpfu.itis.bagaviev.api.domain.repository.MusicControllerRepository
import javax.inject.Inject

class MusicControllerInteractorImpl @Inject constructor(
    private val musicControllerRepository: MusicControllerRepository
) : MusicControllerInteractor {

    override var currentMusicItem = musicControllerRepository.currentMusicItem

    override var isPlaying = musicControllerRepository.isPlaying

    override val currentPlayingItemDuration = musicControllerRepository.currentPlayingItemDuration

    override var currentPlayingPositionInMs = musicControllerRepository.currentPlayingPositionInMs

    override fun play() {
        musicControllerRepository.play()
    }

    override fun play(musicItem: MusicItem) {
        musicControllerRepository.play(musicItem)
    }

    override fun add(musicItem: MusicItem) {
        musicControllerRepository.add(musicItem)
    }

    override fun add(musicItemList: List<MusicItem>) {
        musicControllerRepository.add(musicItemList)
    }

    override fun pause() {
        musicControllerRepository.pause()
    }

    override fun playNext() {
        musicControllerRepository.playNext()
    }

    override fun playPrevious() {
        musicControllerRepository.playPrevious()
    }

    override fun seekTo(positionInMs: Long) {
        musicControllerRepository.seekTo(positionInMs)
    }
}