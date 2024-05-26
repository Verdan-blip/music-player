package ru.kpfu.itis.bagaviev.feature.upload.presentation.state

import ru.kpfu.itis.bagaviev.feature.upload.presentation.entity.UserModel

data class UiState(
    val trackTitle: String? = null,
    val authors: List<UserModel> = listOf(),
    val smallCoverUri: String? = null,
    val coverUri: String? = null,
    val audioFileName: String? = null,
    val clipFileName: String? = null,
    val isClipCorrectionActive: Boolean = false,
    val clipStartTime: String? = null,
    val clipEndTime: String? = null
)