package ru.kpfu.itis.bagaviev.feed.domain.playlists.entites.responses

import android.net.Uri
import ru.kpfu.itis.bagaviev.feed.domain.tracks.entites.responses.TrackResponseModel
import java.sql.Timestamp

class PlaylistDetailsResponseModel(

    val id: Long,

    val title: String,

    val coverUri: Uri,

    val tracks: List<TrackResponseModel>,

    val createdTime: Timestamp,

    val playsCount: Int
)