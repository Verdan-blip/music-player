package ru.kpfu.itis.bagaviev.data.music.impl.data.playlists.mapper

import ru.kpfu.itis.bagaviev.data.music.api.data.playlists.entities.PlaylistDataEntity
import ru.kpfu.itis.bagaviev.data.music.api.data.playlists.entities.PlaylistDetailsDataEntity
import ru.kpfu.itis.bagaviev.data.music.impl.data.playlists.pojo.responses.PlaylistDetailsResponse
import ru.kpfu.itis.bagaviev.data.music.impl.data.playlists.pojo.responses.PlaylistResponse
import ru.kpfu.itis.bagaviev.data.music.impl.data.tracks.mapper.toTrackDataEntity
import ru.kpfu.itis.bagaviev.data.music.impl.data.users.mapper.toUserDataEntity
import java.net.URI
import java.text.SimpleDateFormat
import java.util.Locale

fun PlaylistResponse.toPlaylistDataEntity(): PlaylistDataEntity =
    PlaylistDataEntity(
        id = id,
        title = title,
        coverUri = URI.create(coverUri),
        user = user.toUserDataEntity(),
        tracks = tracks.map { track -> track.toTrackDataEntity() }
    )

fun PlaylistDetailsResponse.toPlaylistDetailsDataEntity(): PlaylistDetailsDataEntity = run {
    val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    PlaylistDetailsDataEntity(
        id = id,
        title = title,
        coverUri = URI.create(coverUri),
        user = user.toUserDataEntity(),
        tracks = tracks.map { track -> track.toTrackDataEntity() },
        createdDate = dateFormat.parse(createdDate)
            ?: throw IllegalStateException("Unknown created date format $createdDate"),
        playsCount = playsCount
    )
}
