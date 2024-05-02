package ru.kpfu.itis.bagaviev.glue.feed

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.kpfu.itis.bagaviev.music.data.playlists.repository.PlaylistDataRepository
import ru.kpfu.itis.bagaviev.music.data.tracks.entities.responses.TrackDetailsResponseEntity
import ru.kpfu.itis.bagaviev.music.data.tracks.repository.TrackDataRepository
import ru.kpfu.itis.bagaviev.feed.impl.TracksPlaylistsController
import ru.kpfu.itis.bagaviev.player.api.domain.entities.MusicItem
import ru.kpfu.itis.bagaviev.player.api.domain.interactor.MusicControllerInteractor
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

    private fun trackDetailsToMusicItem(trackDetails: TrackDetailsResponseEntity): MusicItem =
        MusicItem(
            id = trackDetails.id,
            title = trackDetails.title,
            authors = trackDetails.users.map { user -> user.login },
            genre = trackDetails.genre,
            audioFileUri = trackDetails.audioFileUri.toURI(),
            coverUri = trackDetails.coverUri.toURI()
        )

    private fun add(trackId: Long) {
        GlobalScope.launch(Dispatchers.Main) {
            trackDataRepository.getById(trackId)?.also { trackDetails ->
                musicControllerInteractor.add(
                    trackDetailsToMusicItem(trackDetails)
                )
            }
        }
    }

    override fun play() {
        musicControllerInteractor.play()
    }

    override fun playTrack(trackId: Long) {
        GlobalScope.launch(Dispatchers.IO) {
            trackDataRepository.getById(trackId)?.also { trackDetails ->
                withContext(Dispatchers.Main) {
                    musicControllerInteractor.clearQueue()
                    musicControllerInteractor.play(
                        trackDetailsToMusicItem(trackDetails)
                    )
                }
            }
        }
    }

    override fun playPlaylist(playlistId: Long) {
        GlobalScope.launch(Dispatchers.IO) {
            playlistDataRepository.getById(playlistId)?.also { playlistDetails ->
                withContext(Dispatchers.Main) {
                    playlistDetails.tracks.forEach { track ->
                        add(track.id)
                    }
                    playNext()
                }
            }
        }
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