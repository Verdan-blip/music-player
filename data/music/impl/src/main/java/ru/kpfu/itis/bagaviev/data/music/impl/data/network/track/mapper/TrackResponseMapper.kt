package ru.kpfu.itis.bagaviev.data.music.impl.data.network.track.mapper

import ru.kpfu.itis.bagaviev.data.music.api.data.network.track.entity.TrackDataEntity
import ru.kpfu.itis.bagaviev.data.music.api.data.network.track.entity.TrackDetailsDataEntity
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.track.pojo.responses.TrackDetailsResponse
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.track.pojo.responses.TrackResponse
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.user.mapper.toUserDataEntity
import java.net.URI
import java.text.SimpleDateFormat
import java.util.Locale

fun TrackResponse.toTrackDataEntity(): TrackDataEntity =
    TrackDataEntity(
        id = trackId,
        title = title,
        users = users.map { user -> user.toUserDataEntity() },
        smallCoverUri = URI.create(smallCoverUri)
    )

fun TrackDetailsResponse.toTrackDetailsDataEntity(): TrackDetailsDataEntity = run {
    val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    TrackDetailsDataEntity(
        id = trackId,
        title = title,
        lyrics = lyrics,
        genre = genre,
        users = users.map { user -> user.toUserDataEntity() },
        smallCoverUri = URI.create(smallCoverUri),
        coverUri = URI.create(coverUri),
        audioFileUri = URI.create(audioFileUri),
        releaseDate = dateFormat.parse(releaseDate)
            ?: throw IllegalStateException("Unknown release date format: $releaseDate"),
        playsCount = playsCount,
        clipDataEntity = clipData?.toClipDataEntity()
    )
}