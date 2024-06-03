package ru.kpfu.itis.bagaviev.presentation.state

import ru.kpfu.itis.bagaviev.common.base.music.BaseMusicViewModel

data class UiState(
    val clipData: BaseMusicViewModel.ClipData? = null,
    val backgroundUri: String? = null
)