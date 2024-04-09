package ru.kpfu.itis.bagaviev.player.presentation.states

import ru.kpfu.itis.bagaviev.player.presentation.entities.MusicItem

sealed class UIMusicEvent {
    data object PlayPause : UIMusicEvent()

    data object Next : UIMusicEvent()

    data object Previous : UIMusicEvent()

    data class SeekTo(val position: Float) : UIMusicEvent()

    data class UpdateProgress(val newPosition: Float) : UIMusicEvent()

    data class SelectedAudioChange(private val musicItem: MusicItem) : UIMusicEvent()
}