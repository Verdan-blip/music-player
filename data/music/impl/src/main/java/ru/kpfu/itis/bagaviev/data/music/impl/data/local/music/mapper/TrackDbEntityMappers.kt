package ru.kpfu.itis.bagaviev.data.music.impl.data.local.music.mapper

import ru.kpfu.itis.bagaviev.common.util.extensions.toURI
import ru.kpfu.itis.bagaviev.data.music.api.data.network.track.entity.TrackDataEntity
import ru.kpfu.itis.bagaviev.data.music.impl.data.local.music.entity.TrackDbEntity
import ru.kpfu.itis.bagaviev.data.music.impl.data.local.music.entity.TrackWithUsers

fun TrackWithUsers.toTrackDataEntity(): TrackDataEntity = TrackDataEntity(
    id = track.id,
    title = track.title,
    smallCoverUri = track.smallCoverUri.toURI(),
    users = users.map { userDbEntity -> userDbEntity.toUserDataEntity() }
)

fun TrackDataEntity.toTrackDbEntity(): TrackDbEntity =
    TrackDbEntity(
        id = id,
        title = title,
        smallCoverUri = smallCoverUri.toString()
    )