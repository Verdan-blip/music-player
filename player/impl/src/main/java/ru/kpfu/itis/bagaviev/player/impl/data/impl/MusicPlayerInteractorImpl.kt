package ru.kpfu.itis.bagaviev.player.impl.data.impl

import ru.kpfu.itis.bagaviev.player.api.domain.entities.MusicItem
import ru.kpfu.itis.bagaviev.player.api.domain.interactor.MusicPlayerInteractor
import ru.kpfu.itis.bagaviev.player.api.domain.repository.MusicPlayerRepository
import javax.inject.Inject

class MusicPlayerInteractorImpl @Inject constructor(
    private val musicPlayerRepository: MusicPlayerRepository
) : MusicPlayerInteractor {

    override val playerCallback = musicPlayerRepository.playerCallback

    override val playerState = musicPlayerRepository.playerState

    override fun play() {
        musicPlayerRepository.play()
    }

    override fun play(musicItem: MusicItem) {
        musicPlayerRepository.play(musicItem)
    }

    override fun add(musicItem: MusicItem) {
        musicPlayerRepository.add(musicItem)
    }

    override fun add(musicItemList: List<MusicItem>) {
        musicPlayerRepository.add(musicItemList)
    }

    override fun pause() {
        musicPlayerRepository.pause()
    }

    override fun playNext() {
        musicPlayerRepository.playNext()
    }

    override fun playPrevious() {
        musicPlayerRepository.playPrevious()
    }

    override fun seekTo(positionInMs: Long) {
        musicPlayerRepository.seekTo(positionInMs)
    }

    override fun clearQueue() {
        musicPlayerRepository.clearQueue()
    }
}