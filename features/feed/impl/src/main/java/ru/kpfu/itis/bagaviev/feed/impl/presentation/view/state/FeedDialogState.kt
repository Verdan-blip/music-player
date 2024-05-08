package ru.kpfu.itis.bagaviev.feed.impl.presentation.view.state

import ru.kpfu.itis.bagaviev.feed.impl.presentation.entities.playlists.PlaylistDetailsModel
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entities.tracks.TrackDetailsModel

sealed class FeedDialogState {

    data class TrackDetails(val trackDetails: TrackDetailsModel) : FeedDialogState()

    data class PlaylistDetails(val playlistDetails: PlaylistDetailsModel) : FeedDialogState()
}