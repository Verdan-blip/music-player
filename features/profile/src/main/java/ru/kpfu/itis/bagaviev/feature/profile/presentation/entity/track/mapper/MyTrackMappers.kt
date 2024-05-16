package ru.kpfu.itis.bagaviev.feature.profile.presentation.entity.track.mapper

import ru.kpfu.itis.bagaviev.common.util.extensions.toUri
import ru.kpfu.itis.bagaviev.feature.profile.domain.entity.track.MyTrack
import ru.kpfu.itis.bagaviev.feature.profile.presentation.entity.user.mapper.toMyUserModel
import ru.kpfu.itis.bagaviev.feature.profile.presentation.entity.track.MyTrackModel

fun MyTrack.toMyTrackModel(): MyTrackModel =
    MyTrackModel(
        id = id,
        title = title,
        users = users.map { user -> user.toMyUserModel() },
        smallCoverUri = smallCoverUri.toUri()
    )