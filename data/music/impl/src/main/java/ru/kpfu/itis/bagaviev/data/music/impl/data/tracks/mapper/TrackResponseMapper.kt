package ru.kpfu.itis.bagaviev.data.music.impl.data.tracks.mapper

import ru.kpfu.itis.bagaviev.data.music.api.data.tracks.entities.TrackDataEntity
import ru.kpfu.itis.bagaviev.data.music.api.data.tracks.entities.TrackDetailsDataEntity
import ru.kpfu.itis.bagaviev.data.music.impl.data.tracks.pojo.responses.TrackDetailsResponse
import ru.kpfu.itis.bagaviev.data.music.impl.data.tracks.pojo.responses.TrackResponse
import ru.kpfu.itis.bagaviev.data.music.impl.data.users.mapper.toUserDataEntity
import java.net.URI
import java.text.SimpleDateFormat
import java.util.Locale

fun TrackResponse.toTrackDataEntity(): TrackDataEntity =
    TrackDataEntity(
        id = id,
        title = title,
        users = users.map { user -> user.toUserDataEntity() },
        smallCoverUri = URI.create(smallCoverUri)
    )

fun TrackDetailsResponse.toTrackDetailsDataEntity(): TrackDetailsDataEntity = run {
    val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    TrackDetailsDataEntity(
        id = id,
        title = title,
        lyrics = lyrics,
        genre = genre,
        users = users.map { user -> user.toUserDataEntity() },
        smallCoverUri = URI.create(smallCoverUri),
        coverUri = URI.create(coverUri),
        audioFileUri = URI.create(audioFileUri),
        videoFileUri = videoFileUri?.let(URI::create),
        releaseDate = dateFormat.parse(releaseDate)
            ?: throw IllegalStateException("Unknown release date format: $releaseDate"),
        playsCount = playsCount
    )
}