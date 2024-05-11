package ru.kpfu.itis.bagaviev.feature.search.impl.presentation.view.state

import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.entities.playlists.PlaylistModel
import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.entities.tracks.TrackModel
import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.entities.users.UserModel
import ru.kpfu.itis.bagaviev.player.api.domain.entities.MusicItem

data class SearchUiState(
    val foundTracks: List<TrackModel> = listOf(),
    val foundPlaylists: List<PlaylistModel> = listOf(),
    val foundUsers: List<UserModel> = listOf(),
    val playingMusicItem: MusicItem? = null,
    val isPlaying: Boolean = false
)