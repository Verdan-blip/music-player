package ru.kpfu.itis.bagaviev.glue.feed

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.kpfu.itis.bagaviev.api.domain.entities.MusicItem
import ru.kpfu.itis.bagaviev.api.domain.interactor.MusicControllerInteractor
import ru.kpfu.itis.bagaviev.data.playlists.repository.PlaylistDataRepository
import ru.kpfu.itis.bagaviev.data.tracks.repository.TrackDataRepository
import ru.kpfu.itis.bagaviev.impl.TracksPlaylistsController
import ru.kpfu.itis.common.util.extensions.toURI
import javax.inject.Inject

@OptIn(DelicateCoroutinesApi::class)
class AdapterTracksPlaylistsController @Inject constructor(
    private val musicControllerInteractor: MusicControllerInteractor,
    private val trackDataRepository: TrackDataRepository,
    private val playlistDataRepository: PlaylistDataRepository
): TracksPlaylistsController {

    override val currentTrackId = MutableStateFlow<Long?>(null)

    override val currentPlayingItemProgressInMs = musicControllerInteractor.currentPlayingPositionInMs

    override val currentPlayingItemDuration = musicControllerInteractor.currentPlayingItemDuration

    override val isPlaying: StateFlow<Boolean?> = musicControllerInteractor.isPlaying

    init {
        GlobalScope.launch {
            launch { collectCurrentTrackId() }
        }
    }

    private suspend fun collectCurrentTrackId() {
        musicControllerInteractor.currentMusicItem.collect { musicItem ->
            currentTrackId.emit(musicItem?.id)
        }
    }

    override fun play() {
        musicControllerInteractor.play()
    }

    override fun playTrack(trackId: Long) {
        GlobalScope.launch(Dispatchers.IO) {
            trackDataRepository.getById(trackId)?.also { trackDetails ->
                withContext(Dispatchers.Main) {
                    musicControllerInteractor.play(
                        MusicItem(
                            id = trackId,
                            title = trackDetails.title,
                            authors = trackDetails.users.map { user -> user.login },
                            genre = trackDetails.genre,
                            audioFileUri = trackDetails.audioFileUri.toURI(),
                            coverUri = trackDetails.coverUri.toURI()
                        )
                    )
                }
            }
        }
    }

    override fun playPlaylist(playlistId: Long) {

    }

    override fun pause() {
        musicControllerInteractor.pause()
    }

    override fun playNext() {
        musicControllerInteractor.playNext()
    }

    override fun playPrevious() {
        musicControllerInteractor.playPrevious()
    }

    override fun seekTo(positionInMs: Long) {
        musicControllerInteractor.seekTo(positionInMs)
    }
}