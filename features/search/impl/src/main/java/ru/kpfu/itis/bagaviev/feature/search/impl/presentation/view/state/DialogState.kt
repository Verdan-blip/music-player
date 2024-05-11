package ru.kpfu.itis.bagaviev.feature.search.impl.presentation.view.state

import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.entities.playlists.PlaylistDetailsModel
import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.entities.tracks.TrackDetailsModel

sealed class DialogState {

    data class TrackDetails(val trackDetails: TrackDetailsModel) : DialogState()

    data class PlaylistDetails(val playlistDetails: PlaylistDetailsModel) : DialogState()
}