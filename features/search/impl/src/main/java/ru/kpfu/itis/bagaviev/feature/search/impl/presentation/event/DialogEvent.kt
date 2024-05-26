package ru.kpfu.itis.bagaviev.feature.search.impl.presentation.event

import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.entities.playlist.PlaylistDetailsModel
import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.entities.track.TrackDetailsModel

sealed class DialogEvent {

    data class TrackDetails(val trackDetails: TrackDetailsModel) : DialogEvent()

    data class PlaylistDetails(val playlistDetails: PlaylistDetailsModel) : DialogEvent()
}