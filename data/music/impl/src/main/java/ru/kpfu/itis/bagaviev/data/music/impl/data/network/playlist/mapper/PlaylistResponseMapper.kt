package ru.kpfu.itis.bagaviev.data.music.impl.data.network.playlist.mapper

import ru.kpfu.itis.bagaviev.data.music.api.data.network.playlist.entity.PlaylistDataEntity
import ru.kpfu.itis.bagaviev.data.music.api.data.network.playlist.entity.PlaylistDetailsDataEntity
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.playlist.pojo.responses.PlaylistDetailsResponse
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.playlist.pojo.responses.PlaylistResponse
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.track.mapper.toTrackDataEntity
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.user.mapper.toUserDataEntity
import java.net.URI
import java.text.SimpleDateFormat
import java.util.Locale

fun PlaylistResponse.toPlaylistDataEntity(): PlaylistDataEntity =
    PlaylistDataEntity(
        id = playlistId,
        title = title,
        coverUri = URI.create(coverUri),
        user = user.toUserDataEntity(),
        tracks = tracks.map { track -> track.toTrackDataEntity() }
    )

fun PlaylistDetailsResponse.toPlaylistDetailsDataEntity(): PlaylistDetailsDataEntity = run {
    val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    PlaylistDetailsDataEntity(
        id = playlistId,
        title = title,
        coverUri = URI.create(coverUri),
        user = user.toUserDataEntity(),
        tracks = tracks.map { track -> track.toTrackDataEntity() },
        createdDate = dateFormat.parse(createdDate)
            ?: throw IllegalStateException("Unknown created date format $createdDate"),
        playsCount = playsCount
    )
}
