package ru.kpfu.itis.bagaviev.feed.impl.presentation.view.state

import android.net.Uri
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entity.playlist.PlaylistModel
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entity.track.TrackModel
import ru.kpfu.itis.bagaviev.player.api.domain.entities.MusicItem

data class FeedUiState(
    val background: Uri? = null,
    val popularTracks: List<TrackModel> = listOf(),
    val popularPlaylists: List<PlaylistModel> = listOf(),
    val playingMusicItem: MusicItem? = null,
    val isPlaying: Boolean = false,
)