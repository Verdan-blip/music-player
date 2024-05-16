package ru.kpfu.itis.bagaviev.features.profile.mapper

import ru.kpfu.itis.bagaviev.data.music.api.data.network.track.entities.TrackDataEntity
import ru.kpfu.itis.bagaviev.feature.profile.domain.entity.track.MyTrack

fun TrackDataEntity.toMyTrack(): MyTrack = MyTrack(
    id = id,
    title = title,
    smallCoverUri = smallCoverUri,
    users = users.map { user -> user.toUser() }
)