package ru.kpfu.itis.bagaviev.impl.presentation.entities.tracks.mappers

import androidx.core.net.toUri
import ru.kpfu.itis.bagaviev.api.domain.tracks.entites.responses.TrackDetailsResponse
import ru.kpfu.itis.bagaviev.api.domain.tracks.entites.responses.TrackResponse
import ru.kpfu.itis.bagaviev.impl.presentation.entities.users.mappers.toUserResponse
import ru.kpfu.itis.bagaviev.impl.presentation.entities.users.mappers.toUserResponseModel
import ru.kpfu.itis.bagaviev.feed.domain.tracks.entites.responses.TrackDetailsResponseModel
import ru.kpfu.itis.bagaviev.feed.domain.tracks.entites.responses.TrackResponseModel
import ru.kpfu.itis.common.util.extensions.toURI
import ru.kpfu.itis.common.util.extensions.toUri

fun TrackResponse.toTrackResponseModel(): TrackResponseModel =
    TrackResponseModel(
        id = id,
        title = title,
        users = users.map { user -> user.toUserResponseModel() },
        smallCoverUri = smallCoverUri.toUri()
    )

fun TrackResponseModel.toTrackResponse(): TrackResponse =
    TrackResponse(
        id = id,
        title = title,
        users = users.map { user -> user.toUserResponse() },
        smallCoverUri = smallCoverUri.toString()
    )

fun TrackDetailsResponse.toTrackDetailsResponseModel(): TrackDetailsResponseModel =
    TrackDetailsResponseModel(
        id = id,
        title = title,
        smallCoverUri = smallCoverUri.toUri(),
        coverUri = coverUri.toUri(),
        audioFileUri = coverUri.toUri(),
        releaseTime = releaseTime,
        playsCount = playsCount
    )

fun TrackDetailsResponseModel.toTrackDetailsResponse(): TrackDetailsResponse =
    TrackDetailsResponse(
        id = id,
        title = title,
        smallCoverUri = smallCoverUri.toURI(),
        coverUri = coverUri.toURI(),
        audioFileUri = coverUri.toURI(),
        releaseTime = releaseTime,
        playsCount = playsCount
    )