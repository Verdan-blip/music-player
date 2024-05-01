package ru.kpfu.itis.bagaviev.impl

import kotlinx.coroutines.flow.StateFlow

interface TracksPlaylistsController {

    val currentTrackId: StateFlow<Long?>

    val currentPlayingItemProgressInMs: StateFlow<Long?>

    val currentPlayingItemDuration: StateFlow<Long?>

    val isPlaying: StateFlow<Boolean?>

    fun play()

    fun playTrack(trackId: Long)

    fun playPlaylist(playlistId: Long)

    fun pause()

    fun playNext()

    fun playPrevious()

    fun seekTo(positionInMs: Long)
}