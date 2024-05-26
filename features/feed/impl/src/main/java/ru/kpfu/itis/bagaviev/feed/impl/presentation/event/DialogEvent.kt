package ru.kpfu.itis.bagaviev.feed.impl.presentation.event

import ru.kpfu.itis.bagaviev.feed.impl.presentation.entity.playlist.PlaylistDetailsModel
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entity.track.TrackDetailsModel

sealed class DialogEvent {

    data class TrackDetails(val trackDetails: TrackDetailsModel) : DialogEvent()

    data class PlaylistDetails(val playlistDetails: PlaylistDetailsModel) : DialogEvent()
}