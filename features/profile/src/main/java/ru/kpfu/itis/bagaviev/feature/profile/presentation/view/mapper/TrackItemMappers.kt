package ru.kpfu.itis.bagaviev.feature.profile.presentation.view.mapper

import ru.kpfu.itis.bagaviev.feature.profile.presentation.entity.track.MyTrackModel
import ru.kpfu.itis.bagaviev.theme.recyclerview.model.TrackItem

fun MyTrackModel.toTrackItem(): TrackItem =
    TrackItem(
        id = id,
        title = title,
        users = users.map { user -> user.login },
        smallCoverUri = smallCoverUri
    )